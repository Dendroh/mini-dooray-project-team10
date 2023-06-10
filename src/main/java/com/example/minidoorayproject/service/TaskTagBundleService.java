package com.example.minidoorayproject.service;

import com.example.minidoorayproject.entity.TaskTagBundle;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.TaskTagBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTagBundleService {

    private final TaskTagBundleRepository taskTagBundleRepository;

    @Autowired
    public TaskTagBundleService(TaskTagBundleRepository taskTagBundleRepository) {
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
