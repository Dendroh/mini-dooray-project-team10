package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.domain.TaskPostReq;
import com.example.minidoorayproject.domain.TaskUpdateReq;

import java.util.List;

public interface TaskService {
    List<TaskDtoResp> getTasksByProjectId(Integer projectId);

    List<TaskDtoResp> getTasksByMemberEmail(String email);

    TaskDtoResp getTaskByTaskId(Integer taskId);

    TaskDtoResp createTaskByDto(TaskPostReq postReq);

    TaskDtoResp updateTask(TaskUpdateReq updateReq);

    TaskDtoResp updateTask(int id, TaskDto taskDto);

    void deleteTask(Integer id);
}
