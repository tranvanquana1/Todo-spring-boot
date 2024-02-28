package org.example.todo.requests;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(SnakeCaseStrategy.class)
public class TaskRequest {
    private Long id;
//    @NotEmpty("Mã nhân viên bắt buộc nhập")
    private Integer userId;

//    @NotEmpty("Tiêu đề bắt buộc nhập")
    private String title;

    private String description;

    private Integer priority;

    private LocalDate dueDate;
}
