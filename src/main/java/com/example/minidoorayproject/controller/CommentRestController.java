package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.CommentPostReq;
import com.example.minidoorayproject.domain.CommentResp;
import com.example.minidoorayproject.domain.CommentUpdateReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentRestController {
    private final CommentService service;

    @GetMapping("/comments/{taskId}")
    public List<CommentResp> getCommentsByTaskId(@PathVariable("taskId") Integer taskId) {
        return service.getCommentsByTaskId(taskId);
    }

    @PostMapping("/comments/")
    public CommentResp postCommentByDto(@Valid @RequestBody CommentPostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return service.createCommentsByDto(postReq);
    }

    @PutMapping("/comments/")
    public CommentResp putCommentByDto(@Valid @RequestBody CommentUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return service.updateCommentsByDto(updateReq);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteCommentById(@PathVariable("commentId") Integer commentId) {
        service.deleteCommentBy(commentId);
    }
}
