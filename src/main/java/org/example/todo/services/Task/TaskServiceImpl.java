package org.example.todo.services.Task;

import lombok.RequiredArgsConstructor;
import org.example.todo.entities.Task;
import org.example.todo.repositories.TaskRepository;
import org.example.todo.requests.TaskRequest;
import org.example.todo.responses.DefaultResponse;
import org.example.todo.responses.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public DefaultResponse<TaskResponse> create(TaskRequest taskRequest) {
        Task task = Task.of(taskRequest);
        task.setCreatedAt(LocalDateTime.now());
        task = taskRepository.save(task);

        return DefaultResponse.success(TaskResponse.of(task));
    }

    @Override
    public DefaultResponse<List<TaskResponse>> list(Pageable pageable) {
        Page<Task> page = taskRepository.findAll(pageable);

        return DefaultResponse.success(
                page,
                page.hasContent() ? page.get().map(TaskResponse::of).toList() : Collections.emptyList()
        );
    }

    @Override
    public DefaultResponse<TaskResponse> update(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Không tìm thấy Task với ID %s !", taskRequest.getId())));

        // Todo: set các thông tin khác
        task.setDescription(taskRequest.getDescription());
        task.setDueDate(taskRequest.getDueDate());
        task.setModifiedAt(LocalDateTime.now());
        task = taskRepository.save(task);

        return DefaultResponse.success(TaskResponse.of(task));
    }

    @Override
    public DefaultResponse<TaskResponse> delete(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Không tìm thấy Task với ID %s !", taskRequest.getId())));

        taskRepository.delete(task);

        return DefaultResponse.success(null);
    }

    @Override
    public DefaultResponse<TaskResponse> completeTask(TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Không tìm thấy Task với ID %s !", taskRequest.getId())));

        task.setStatus(taskRequest.getStatus());
        task.setModifiedAt(LocalDateTime.now());

        task = taskRepository.save(task);

        return DefaultResponse.success(TaskResponse.of(task));
    }

}
