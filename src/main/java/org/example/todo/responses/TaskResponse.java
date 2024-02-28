package org.example.todo.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.example.todo.constants.Priority;
import org.example.todo.entities.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class TaskResponse {
    private Long id;
    private Integer userId;
    private String title;
    private String description;
    private Integer priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static TaskResponse of(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .userId(task.getUserId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority().getValue())
                .dueDate(task.getDueDate())
                .build();
    }
}
