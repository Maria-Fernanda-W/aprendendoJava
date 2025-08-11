package br.com.mariafernanda.todolist.controller;

import br.com.mariafernanda.todolist.dto.request.UserRequestDTO;
import br.com.mariafernanda.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que será uma controller rest, API
@RequestMapping("/users") //caminho principal da API /users
public class UserController {

    @Autowired //para o spring fazer a injeção de dependências
    private UserService userService;

    //adicionar usuário
    @PostMapping
    public ResponseEntity create(@RequestBody UserRequestDTO dto //body da requição
    ) {
        return userService.create(dto);
    }

}
