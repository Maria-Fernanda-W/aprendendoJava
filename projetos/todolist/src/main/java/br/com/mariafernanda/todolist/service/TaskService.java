package br.com.mariafernanda.todolist.service;

import br.com.mariafernanda.todolist.dto.request.TaskRequestDTO;
import br.com.mariafernanda.todolist.dto.response.TaskResponseDTO;
import br.com.mariafernanda.todolist.model.TaskModel;
import br.com.mariafernanda.todolist.repository.ITaskRepository;
import br.com.mariafernanda.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired //para o spring fazer a injeção de dependências
    private ITaskRepository taskRepository;

    public ResponseEntity create(@RequestBody TaskRequestDTO dto, //body da requição
                                 HttpServletRequest request //path da requição
    ) {
        var currentDate = LocalDateTime.now(); //pega o valor da data atual

        //se a data atual for maior que a data de inicio da tarefa
        if (currentDate.isAfter(dto.getStartAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora de início deve ser maior ou igual a atual");
        }

        //se a data atual for maior que a data final da tarefa
        if (currentDate.isAfter(dto.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora final deve ser maior ou igual a atual");
        }

        //se a data de final for menor ou igual a inicial
        if (dto.getEndAt().isBefore(dto.getStartAt()) || dto.getEndAt().isEqual(dto.getStartAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora final dever maior que a data/hora de início");
        }

        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição
        //taskModel.setIdUser((UUID) idUser); //altera o idUser da task

        TaskModel model = new TaskModel();
        try {
            model.setTitle(dto.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.setDescription(dto.getDescription());
        model.setStartAt(dto.getStartAt());
        model.setEndAt(dto.getEndAt());
        model.setPriority(dto.getPriority());
        model.setIdUser((UUID) idUser);

        var taskCreated = this.taskRepository.save(model); //salva a task no banco de dados

        TaskResponseDTO responseDTO = new TaskResponseDTO(taskCreated);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO); //retornar status 201 e a task criada
    }

    public ResponseEntity list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição
        List<TaskModel> tasksModel = taskRepository.findByIdUser((UUID) idUser); //procura task pelo idUser

        if (tasksModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma tarefa encontrada");
        }

        List<TaskResponseDTO> tasksDTO = tasksModel.stream().map(task -> new TaskResponseDTO(task)).toList();

        return ResponseEntity.ok(tasksDTO); //retorna as tasks do usuário
    }

    public ResponseEntity update(@RequestBody TaskRequestDTO dto,  //body da requição
                                 HttpServletRequest request, //path da requição
                                 @PathVariable UUID id //parâmetros da requição
    ) {

        TaskModel task = this.taskRepository.findById(id).orElse(null);
        //task encontrada pelo parâmetro da requisiçaõ ou nulo

        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição

        //se o idUser da task encontrada for diferente do idUser da autenticação
        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    "Usuário não tem permissão para alterar essas tarefa");
        }

        Utils.copyNonNullProperties(dto, task); //altera na task apenas as infromações passadas

        TaskModel model = new TaskModel();
        try {
            model.setTitle(dto.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.setDescription(dto.getDescription());
        model.setStartAt(dto.getStartAt());
        model.setEndAt(dto.getEndAt());
        model.setPriority(dto.getPriority());
        model.setIdUser((UUID) idUser);

        var taskUpdated = this.taskRepository.save(task); //salva a alteração

        TaskResponseDTO responseDTO = new TaskResponseDTO(taskUpdated);

        return ResponseEntity.ok(responseDTO); //retornar status 200 e a task atualizada
    }

    public ResponseEntity delete(HttpServletRequest request, @PathVariable UUID id) {
        var task = this.taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        this.taskRepository.delete(task);

        return ResponseEntity.ok("Task excluída com sucesso");
    }

}
