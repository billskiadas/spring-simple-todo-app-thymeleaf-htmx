package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findBydId(Long id) {
        return taskRepository.findById(id);
    }

    public void add(Task task) {
        taskRepository.save(task);
    }

    public void completeToggled(Task task) {
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
