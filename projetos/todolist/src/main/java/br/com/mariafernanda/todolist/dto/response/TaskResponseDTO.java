package br.com.mariafernanda.todolist.dto.response;

import br.com.mariafernanda.todolist.model.TaskModel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class TaskResponseDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    public TaskResponseDTO(TaskModel model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.startAt = model.getStartAt();
        this.endAt = model.getEndAt();
        this.priority = model.getPriority();
    }
}
