package br.com.mariafernanda.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.mariafernanda.todolist.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Component //par ao spring detectar e registrar automaticamente
public class FilterTaskAuth extends OncePerRequestFilter {
    /* OncePerRequestFilter garente que o filtro só será chamado uma vez por requisição
     * Vai sempre passar por aqui antes de uma requisição
     * */

    @Autowired //para o spring fazer a injeção de dependências
    private IUserRepository userRepository;

    @Override //metodo herdado de OncePerRequestFilter onde fica a lógica do filtro
    protected void doFilterInternal(
            HttpServletRequest request, //requisição
            HttpServletResponse response, //resposta
            FilterChain filterChain //acesso para passar adiente a requisição
    ) throws ServletException, IOException {
        var servletPath = request.getServletPath(); //pega o endpoint da requisição

        if (servletPath.startsWith("/tasks")) { //se começar com /tasks/
            ////1. Recupera a autenticação (username, password)
            var auth = request.getHeader("Authorization");
            //a authorization vem criptografada(encode) em base64, exemplo "Basic bWFyaWFmdzoxMjM0"

            // 1. fazer substring para remover o Basic da frente
            var authEncode = auth.substring("Basic".length()).trim(); //remove a palavra "Basic" e remove os espeços

            // 2. fazer o descriptografar(decode)
            byte[] authDecode = Base64.getDecoder().decode(authEncode);
            String authString = new String(authDecode);  //nesse momento temos "username:password"

            //3. separar o usuário da senha
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            ////2. Validar usuário
            var user = this.userRepository.findByUsername(username);
            if (user == null) { //se o usuário for nulo
                response.sendError(404, "Username não encontrado");

            } else { //se não
                ////3. Validar senha
                var passwordVerify = BCrypt.verifyer().verify(
                        password.toCharArray(), //passa a senha digitada pelo usuário como um array de char
                        user.getPassword() //compara com a senha criptografado do usuário no banco
                );

                if (passwordVerify.verified) { //se a senha estiver certa

                    ///4. Mandar o id do user para a controller
                    //Para enviar informações para controller, é enviado dentro do request como um atributo
                    request.setAttribute("idUser", user.getId());

                    ////5. Seguir requisição (tudo ok)
                    //se ele chegar até esse ponto esta tudo ok, pode continuar com a requisição
                    filterChain.doFilter(request, response);

                } else {
                    response.sendError(401, "Username ou Password incorretos");
                }
            }
        } else {
            //no else não valida nada apenas continua com a requisição
            filterChain.doFilter(request, response);
        }
    }
}
