package com.devopsassignment.Momento.service;

import com.devopsassignment.Momento.model.Task;
import com.devopsassignment.Momento.repository.TaskFileRepository;
import com.devopsassignment.Momento.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskFileRepository taskFileRepository;

    public Task saveTask(Task newTask) {
        Task taskAddedToFile = taskFileRepository.saveTask(newTask);
        System.out.println(taskAddedToFile);
        return taskRepository.save(newTask);
    }

    public List<Task> getTasks() {
        List<Task> allTasks = taskFileRepository.getTasks();
        System.out.println(allTasks);
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        Task task = taskFileRepository.findById(id);
        System.out.println(task);
        return taskRepository.findById(id);
    }

    public void deleteById(Long id) {
        taskFileRepository.deleteById(id);
        taskRepository.deleteById(id);
    }
}
