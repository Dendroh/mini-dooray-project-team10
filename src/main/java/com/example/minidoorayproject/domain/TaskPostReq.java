package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskPostReq {
    @NotBlank
    private String taskName;

    private String content;

    @NotNull
    private Integer projectId;

    @NotNull
    private String writerEmail;
}
