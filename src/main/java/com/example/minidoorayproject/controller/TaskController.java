package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/task/{projectId}")
    public List<TaskDtoResp> getTaskByProjectId(@PathVariable("projectId") Integer projectId) {
        return service.getTasksByProjectId(projectId);
    }

    @GetMapping("/task/memberEmail/{email}")
    public List<TaskDtoResp> getTaskByMemberEmail(@PathVariable("email") String email) {
        return service.getTasksByMemberEmail(email);
    }



}
