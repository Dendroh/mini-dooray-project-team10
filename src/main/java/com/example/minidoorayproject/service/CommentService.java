package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.CommentPostReq;
import com.example.minidoorayproject.domain.CommentResp;
import com.example.minidoorayproject.domain.CommentUpdateReq;

import java.util.List;

public interface CommentService {
    List<CommentResp> getCommentsByTaskId(Integer taskId);

    CommentResp createCommentsByDto(CommentPostReq postReq);

    CommentResp updateCommentsByDto(CommentUpdateReq updateReq);

    void deleteCommentBy(Integer commentId);
}
