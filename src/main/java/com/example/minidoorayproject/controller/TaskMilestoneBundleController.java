package com.example.minidoorayproject.controller;


import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundleDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundlePostReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.impl.TaskMilestoneBundleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskMilestoneBundleController {

    private final TaskMilestoneBundleServiceImpl taskMilestoneBundleService;


    @GetMapping("/task/milestone/{taskName}")
    public ResponseEntity<List<MileStoneDto>> getAllMilestonesByTaskTitle(@PathVariable String taskName) {
        List<MileStoneDto> milestones = taskMilestoneBundleService.selectAllMilestoneByTaskName(taskName);
        return ResponseEntity.ok(milestones);
    }

    @GetMapping("/milestone/tasks/{milestoneName}")
    public ResponseEntity<List<TaskDto>> getAllTasksByMilestoneName(@PathVariable String milestoneName) {
        List<TaskDto> tasks = taskMilestoneBundleService.selectAllTaskByMilestoneName(milestoneName);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/task/milestone")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskMilestoneBundleDto> createTaskMilestoneBundle(@Valid @RequestBody TaskMilestoneBundlePostReq bundlePostReq, BindingResult result) {
        TaskMilestoneBundleDto bundle = taskMilestoneBundleService.createTaskMilestoneBundle(bundlePostReq);
        if (result.hasErrors())
            throw new ValidationFailedException(result);
        return ResponseEntity.ok(bundle);
    }

    @DeleteMapping("/task/milestone/{taskName}/{milestoneName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteTaskMilestoneBundle(@PathVariable String taskName, @PathVariable String milestoneName) {
        taskMilestoneBundleService.deleteTaskMilestoneBundle(taskName, milestoneName);
        return ResponseEntity.noContent().build();
    }
}
