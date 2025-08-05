package br.com.mariafernanda.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data //adiciona métodos básicos de uma classe, getters, setters, ...
@Entity(name = "tb_users") //define como entidade de banco, tabela chamada tb_users
public class UserModel {

    @Id //define como primary key
    @GeneratedValue(generator = "UUID") //define que o valor será gerado pelo spring, tipo UUID
    private UUID id;

    @Column(unique = true) //define como check key
    private String username;

    private String name;

    private String password;

    @CreationTimestamp //indica que será um timestamp, recebe valor automático
    private LocalDateTime createdAt;

}
