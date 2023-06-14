package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class CommentPostReq {
    @NotBlank
    private String content;

    @NotNull
    private Integer taskId;

    @NotBlank
    private String writerEmail;
}