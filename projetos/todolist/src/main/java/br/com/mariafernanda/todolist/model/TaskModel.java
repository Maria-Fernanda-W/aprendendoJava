package br.com.mariafernanda.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id //define como primary key
    @GeneratedValue(generator = "UUID") //define que o valor será gerado pelo spring, tipo UUID
    private UUID id;

    @Column(length = 50) //define o tamanho máximo da coluna
    private String title;

    private String description;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String priority;

    @CreationTimestamp //indica que será um timestamp, recebe valor automático
    private LocalDateTime createdAt;

    private UUID idUser;

    //setter personalizado validando a quantidade de caracteres
    //esse setter substitui o gerado automaticamente pelo Lombok.
    /*public void setTitle(String title) throws Exception{
        if(title.length() > 50) { //se for maior que 50 lança a execeção
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }*/

}
