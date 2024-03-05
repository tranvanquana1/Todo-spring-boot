package org.example.todo.controllers;

import lombok.RequiredArgsConstructor;
import org.example.todo.requests.TaskRequest;
import org.example.todo.responses.DefaultResponse;
import org.example.todo.responses.TaskResponse;
import org.example.todo.services.Task.TaskService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor

public class TaskController {
    private final TaskService taskService;
    /*
    *  Create task [v]
    *  Modify task [v]
    *  Delete task [v]
    *  Complete task [v]
    *  Filter, search []
    *  Reminder []
    *  History []
    *  Authentication []
    *
    * */

    @GetMapping("/list")
    public ResponseEntity<DefaultResponse<List<TaskResponse>>> list(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());

        return ResponseEntity.ok(taskService.list(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<DefaultResponse<TaskResponse>> create(
            @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(taskService.create(request));
    }

    @PostMapping("/update")
    public ResponseEntity<DefaultResponse<TaskResponse>> update(
            @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(taskService.update(request));
    }

    @PostMapping("/delete")
    public ResponseEntity<DefaultResponse<TaskResponse>> delete(
            @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(taskService.delete(request));
    }

    @PostMapping("/complete")
    public ResponseEntity<DefaultResponse<TaskResponse>> completeTask(
            @RequestBody TaskRequest request
    ) {
        return ResponseEntity.ok(taskService.completeTask(request));
    }
}
