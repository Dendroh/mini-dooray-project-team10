package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TaskDtoResp;

import java.util.List;

public interface TaskService {
    List<TaskDtoResp> getTasksByProjectId(Integer projectId);
}
