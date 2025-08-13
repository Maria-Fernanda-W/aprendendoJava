package br.com.mariafernanda.todolist.dto.request;

import br.com.mariafernanda.todolist.validation.groups.OnCreate;
import br.com.mariafernanda.todolist.validation.groups.OnUpdate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskRequestDTO {

    //validação para o grupo OnCreate -- não pode ser null, vazio ou só com espaços em branco
    @NotBlank(groups = OnCreate.class)
    //validação para os grupo OnCreate e onUpdate -- no mínimo 1 e no máximo 50 caracteres
    @Size(min = 1, max = 50, groups = {OnCreate.class, OnUpdate.class})
    private String title;

    private String description;

    @NotNull(groups = OnCreate.class)
    @FutureOrPresent //validação -- data tem que estar no presente ou no futuro
    private LocalDateTime startAt;

    @NotNull(groups = OnCreate.class)
    @FutureOrPresent
    private LocalDateTime endAt;

    private String priority;
}
