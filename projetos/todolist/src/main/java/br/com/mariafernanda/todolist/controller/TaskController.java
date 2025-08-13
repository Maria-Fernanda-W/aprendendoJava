package br.com.mariafernanda.todolist.controller;

import br.com.mariafernanda.todolist.dto.request.TaskRequestDTO;
import br.com.mariafernanda.todolist.service.TaskService;
import br.com.mariafernanda.todolist.validation.groups.OnCreate;
import br.com.mariafernanda.todolist.validation.groups.OnUpdate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController //indica que será uma controller rest, API
@RequestMapping("/tasks") //caminho principal da API /tasks
public class TaskController {

    @Autowired
    private TaskService taskService;

    //adicionar task
    @PostMapping
    public ResponseEntity create(@Validated(OnCreate.class) @RequestBody TaskRequestDTO dto, //body da requição
                                 HttpServletRequest request //path da requição
    ) {
        //@Validated(OnCreate.class) para validar apenas o que for do grupo OnCreate
        return taskService.create(dto, request);
    }

    //listar tasks
    @GetMapping
    public ResponseEntity list(HttpServletRequest request) {
        return taskService.list(request);
    }

    //altera apenas os dados informados
    @PutMapping("/{id}")
    public ResponseEntity update(@Validated(OnUpdate.class) @RequestBody TaskRequestDTO dto,  //body da requição
                                 HttpServletRequest request, //path da requição
                                 @PathVariable UUID id //parâmetros da requição
    ) {
        //@Validated(OnUpdate.class) para validar apenas o que for do grupo OnUpdate
        return taskService.update(dto, request, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(HttpServletRequest request, @PathVariable UUID id){
        return taskService.delete(request, id);
    }

}
