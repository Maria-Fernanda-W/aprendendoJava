package br.com.mariafernanda.todolist.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.mariafernanda.todolist.dto.request.UserRequestDTO;
import br.com.mariafernanda.todolist.dto.response.UserResponseDTO;
import br.com.mariafernanda.todolist.model.UserModel;
import br.com.mariafernanda.todolist.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired //para o spring fazer a injeção de dependências
    private IUserRepository userRepository;

    public ResponseEntity create(UserRequestDTO dto) {
        UserModel user = this.userRepository.findByUsername(dto.getUsername()); //procura o usuário pelo nome
        if (user != null) { //se encontrar usuário
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        //faz a criptografia da senha
        var passwordHashed = BCrypt.withDefaults().hashToString(12, //nível de criptografia
                                                                dto.getPassword().toCharArray());
        dto.setPassword(passwordHashed); //altera no objeto para senha criptografada

        //Recebe um UserRequestDTO converte para  User Model
        UserModel model = new UserModel();
        model.setName(dto.getName());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());

        var userCreated = this.userRepository.save(model); //salva o usuário(UserModel) no banco de dados

        //Converte o UserModel para UserResponseDTO
        UserResponseDTO responseDTO = new UserResponseDTO(userCreated);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                responseDTO); //retornar status 201 e o usuário(UserResponseDTO) criado
    }

}
