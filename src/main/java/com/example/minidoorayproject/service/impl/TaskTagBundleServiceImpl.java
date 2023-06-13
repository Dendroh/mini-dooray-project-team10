package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.entity.TaskTagBundle;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.TaskTagBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTagBundleServiceImpl {

    private final TaskTagBundleRepository taskTagBundleRepository;

    @Autowired
    public TaskTagBundleServiceImpl(TaskTagBundleRepository taskTagBundleRepository) {
        this.taskTagBundleRepository = taskTagBundleRepository;
    }

    public TaskTagBundle createTaskTagBundle(TaskTagBundle taskTagBundle) {
        return taskTagBundleRepository.save(taskTagBundle);
    }

    public TaskTagBundle getTaskTagBundle(int id) {
        return taskTagBundleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TaskTagBundle", "id", id));
    }

    public void deleteTaskTagBundle(int id) {
        TaskTagBundle taskTagBundle = getTaskTagBundle(id);
        taskTagBundleRepository.delete(taskTagBundle);
    }
}
