package org.example.todo.repositories;

import org.example.todo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepository extends JpaRepository <Task, Long>, JpaSpecificationExecutor<Task> {
}
