package com.example.minidoorayproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResp {
    private Integer commentId;

    private String content;

    private LocalDateTime writeTime;

    private Integer taskId;

    private String writerEmail;

    private String writerName;
}
