package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.entity.Task;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task", "id", id));
    }

    public Task updateTask(int id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTaskName(updatedTask.getTaskName());
                    task.setContent(updatedTask.getContent());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    updatedTask.setTaskId(id);
                    return taskRepository.save(updatedTask);
                });
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}