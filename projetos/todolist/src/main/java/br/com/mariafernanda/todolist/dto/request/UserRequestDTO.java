package br.com.mariafernanda.todolist.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank // validação -- não pode ser null, vazio ou só com espaços em branco
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 4) // validação -- no mínimo 4 caracteres
    private String password;
}
