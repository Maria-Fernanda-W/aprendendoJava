package br.com.mariafernanda.todolist.dto.response;

import br.com.mariafernanda.todolist.model.UserModel;
import lombok.Getter;

@Getter
public class UserResponseDTO {
    private String name;
    private String username;

    public UserResponseDTO(UserModel model) {
        this.name = model.getName();
        this.username = model.getUsername();
    }

}