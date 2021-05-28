package com.devopsassignment.Momento.controller;

import com.devopsassignment.Momento.exceptionhandling.TaskNotFoundExcptn;
import com.devopsassignment.Momento.model.Task;
import com.devopsassignment.Momento.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    // @Autowired
    // TaskService taskService;

    public TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task newTask){
        System.out.println("In controller");
        return taskService.saveTask(newTask);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.findById(id)
                .orElseThrow(() -> new TaskNotFoundExcptn(id));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskService.findById(id)
                .map(task -> {
                    task.setName(newTask.getName());
                    task.setDescription(newTask.getDescription());
                    return taskService.saveTask(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return taskService.saveTask(newTask);
                });
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
