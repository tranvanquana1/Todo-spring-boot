package org.example.todo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.todo.constants.Priority;
import org.example.todo.requests.TaskRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    @Convert(converter = Priority.EnumConverter.class)
    private Priority priority;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    public static Task of(TaskRequest request) {
        return Task.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(Priority.of(request.getPriority()))
                .dueDate(request.getDueDate())
                .status(request.getStatus())
                .build();
    }
}
