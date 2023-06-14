package com.example.minidoorayproject.controller;


import com.example.minidoorayproject.domain.TaskTagBundleDto;
import com.example.minidoorayproject.domain.TaskTagBundlePostReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.TaskTagBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskTagBundleController {
    private final TaskTagBundleService taskTagBundleService;

    @GetMapping("/task/tag/{taskName}")
    public ResponseEntity<List<TaskTagBundleDto>> getAllTagsByTaskName(@PathVariable String taskName) {
        List<TaskTagBundleDto> bundles = taskTagBundleService.selectAllTagsByTaskName(taskName);
        return ResponseEntity.ok(bundles);
    }

    @PostMapping("/task/tag")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskTagBundleDto> createTaskTagBundle(@Valid @RequestBody TaskTagBundlePostReq taskTagBundlePostReq, BindingResult result) {
        TaskTagBundleDto bundleDto = taskTagBundleService.createTaskTagBundle(taskTagBundlePostReq);
        if (result.hasErrors())
            throw new ValidationFailedException(result);
        return ResponseEntity.ok(bundleDto);
    }

    @DeleteMapping("/task/tag/{taskName}/{tagName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteTaskTagBundle(@PathVariable String taskName, @PathVariable String tagName) {
        taskTagBundleService.deleteTaskTagBundle(taskName, tagName);
        return ResponseEntity.noContent().build();
    }
}

