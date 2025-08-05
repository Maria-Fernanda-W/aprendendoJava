package br.com.mariafernanda.todolist.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que será uma controller rest, API
@RequestMapping("/users") //caminho principal da API /users
public class UserController {

    @Autowired //para o spring fazer a injeção de dependências
    private IUserRepository userRepository;

    //adicionar usuário
    @PostMapping
    public ResponseEntity create(@RequestBody UserModel userModel //body da requição
    ) {

        var user = this.userRepository.findByUsername(userModel.getUsername()); //procura o usuário pelo nome
        if (user != null) { //se encontrar usuário
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString( //faz a criptografia
                                                                 12, //nível de criptografia
                                                                 userModel.getPassword().toCharArray()
                                                                 //passa a senha como array de char
        );
        userModel.setPassword(passwordHashed); //altera no objeto para senha criptografada

        var userCreated = this.userRepository.save(userModel); //salva o usuário no banco de dados

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); //retornar status 201 e o usuário criado
    }

}
