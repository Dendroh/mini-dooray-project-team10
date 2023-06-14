package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class CommentUpdateReq {
    @NotNull
    private Integer commentId;

    @NotBlank
    private String content;
}
