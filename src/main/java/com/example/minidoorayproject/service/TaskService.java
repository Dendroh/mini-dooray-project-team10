package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.domain.TaskPostReq;

import java.util.List;

public interface TaskService {
    List<TaskDtoResp> getTasksByProjectId(Integer projectId);

    List<TaskDtoResp> getTasksByMemberEmail(String email);

    TaskDtoResp createTaskByDto(TaskPostReq postReq);
}
