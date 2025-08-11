package br.com.mariafernanda.todolist.repository;

import br.com.mariafernanda.todolist.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    /* essa interface extend a JpaRepository o que transforma ela em um repositório JPA,
       ou seja, ganha método para acessar o banco de dados
     * TaskModel, enitdade que vai ser gerenciada
     * UUID, tipo de ID(pk)
     * */

    //a jpa interpreta o nome do método e gera a consulta (Query Method Naming)
    List<TaskModel> findByIdUser(UUID idUser);

}
