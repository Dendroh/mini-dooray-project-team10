package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TaskUpdateReq {
    @NotNull
    private Integer taskId;

    private String newTaskTitle;

    private String newTaskContent;
}
