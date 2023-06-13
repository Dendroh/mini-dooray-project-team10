package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.entity.Task;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.TaskRepository;
import com.example.minidoorayproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

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

    @Override
    public List<TaskDtoResp> getTasksByProjectId(Integer projectId) {
        List<TaskDto> taskDtoList = taskRepository.getByProject_ProjectId(projectId);

        return taskDtoList.stream()
                .map(TaskServiceImpl::convertToResp)
                .collect(Collectors.toList());
    }

    public static TaskDtoResp convertToResp(TaskDto taskDto) {
        TaskDtoResp resp = new TaskDtoResp();
        resp.setTaskId(taskDto.getTaskId());
        resp.setTaskName(taskDto.getTaskName());
        resp.setContent(taskDto.getContent());
        resp.setWriterEmail(taskDto.getWriter().getMemberEmail());
        resp.setWriteTime(taskDto.getWriteTime());
        resp.setWriterName(taskDto.getWriter().getMemberName());

        return resp;
    }
}