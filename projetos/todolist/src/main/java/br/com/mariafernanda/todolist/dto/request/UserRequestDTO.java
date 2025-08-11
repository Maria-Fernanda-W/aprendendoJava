package br.com.mariafernanda.todolist.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String name;
    private String username;
    private String password;
}
