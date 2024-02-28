package org.example.todo.services.Task;

import org.example.todo.requests.TaskRequest;
import org.example.todo.responses.DefaultResponse;
import org.example.todo.responses.TaskResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    DefaultResponse<TaskResponse> create(TaskRequest taskRequest);

    DefaultResponse<List<TaskResponse>> list(Pageable pageable);
}
