package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class TaskPostReq {
    @NotBlank
    private String taskTitle;

    private String taskContent;

    @NotNull
    private Integer projectId;

    @NotNull
    private String writerEmail;
}
