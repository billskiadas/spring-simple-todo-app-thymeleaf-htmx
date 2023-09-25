package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task newTask, Model model) {
        taskService.add(newTask);
        model.addAttribute("tasks", taskService.findAll());
        return "fragment/taskListFragment";
    }

    @DeleteMapping(value = "/{taskId}/toggle")
    public String toggleTaskCompletion(@PathVariable Long taskId, Model model) {
        taskService.findBydId(taskId).ifPresent(taskService::completeToggled);
        model.addAttribute("tasks", taskService.findAll());
        return "fragment/taskListFragment";
    }

}
