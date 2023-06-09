package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.domain.TaskPostReq;
import com.example.minidoorayproject.domain.TaskUpdateReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/task/{projectId}")
    public List<TaskDtoResp> getTaskByProjectId(@PathVariable("projectId") Integer projectId) {
        return service.getTasksByProjectId(projectId);
    }

    @GetMapping("/task/id/{taskId}")
    public TaskDtoResp getTaskByTaskId(@PathVariable("taskId") Integer taskId) {
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/task/memberEmail/{email}")
    public List<TaskDtoResp> getTaskByMemberEmail(@PathVariable("email") String email) {
        return service.getTasksByMemberEmail(email);
    }

    @PostMapping("/task/")
    public TaskDtoResp postTask(@Valid @RequestBody TaskPostReq postReq) {
        return service.createTaskByDto(postReq);
    }

    @PutMapping("/task/")
    public TaskDtoResp updateTask(@Valid @RequestBody TaskUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return service.updateTask(updateReq);
    }

    @DeleteMapping("/task/{taskId}")
    public void deleteTask(@PathVariable("taskId") Integer taskId) {
        service.deleteTask(taskId);
    }

}
