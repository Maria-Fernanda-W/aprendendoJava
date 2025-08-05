package br.com.mariafernanda.todolist.task;

import br.com.mariafernanda.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController //indica que será uma controller rest, API
@RequestMapping("/tasks") //caminho principal da API /tasks
public class TaskController {

    @Autowired //para o spring fazer a injeção de dependências
    private ITaskRepository taskRepository;

    //adicionar task
    @PostMapping
    public ResponseEntity create(@RequestBody TaskModel taskModel, //body da requição
                                 HttpServletRequest request //path da requição
    ) {
        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição
        taskModel.setIdUser((UUID) idUser); //altera o idUser da task

        var currentDate = LocalDateTime.now(); //pega o valor da data atual

        //se a data atual for maior que a data de inicio da tarefa
        if (currentDate.isAfter(taskModel.getStartAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora de início deve ser maior ou igual a atual");
        }

        //se a data atual for maior que a data final da tarefa
        if (currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora final deve ser maior ou igual a atual");
        }

        //se a data de final for menor ou igual a inicial
        if (taskModel.getEndAt().isBefore(taskModel.getStartAt()) || taskModel.getEndAt().isEqual(
                taskModel.getStartAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "A data/hora final dever maior que a data/hora de início");
        }

        var task = this.taskRepository.save(taskModel); //salva a task no banco de dados
        return ResponseEntity.ok(task); //retornar status 200 e a task criada
    }

    //listar tasks
    @GetMapping
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição
        var tasks = taskRepository.findByIdUser((UUID) idUser); //procura task pelo idUser
        return tasks; //retorna as tasks do usuário
    }

    //altera apenas os dados informados
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel,  //body da requição
                                 HttpServletRequest request, //path da requição
                                 @PathVariable UUID id //parâmetros da requição
    ) {
        var idUser = request.getAttribute("idUser"); //recupera o atributo idUser da requisição
        var task = this.taskRepository.findById(id).orElse(
                null); //task encontrada pelo parâmetro da requisiçaõ ou nulo

        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        //se o idUser da task encontrada for diferente do idUser da autenticação
        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    "Usuário não tem permissão para alterar essas tarefa");
        }

        Utils.copyNonNullProperties(taskModel, task); //altera na task apenas as infromações passadas
        var taskUpdated = this.taskRepository.save(task); //salva a alteração
        return ResponseEntity.ok(taskUpdated); //retornar status 200 e a task atualizada
    }

    /*
    //altera todos os dados, o que não for informado fica nulo, menos os id da task e idUser
    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id) {
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        taskModel.setId(id);
        return this.taskRepository.save(taskModel);
    }
    */

}
