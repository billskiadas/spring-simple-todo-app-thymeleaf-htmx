package com.todo.app.htmx_demo.repository;

import com.todo.app.htmx_demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
