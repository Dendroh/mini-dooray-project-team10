package com.example.minidoorayproject.domain;

import lombok.Getter;
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

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskContent(String content) {
        taskContent = content;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setWriterEmail(String email) {
        writerEmail = email;
    }
}
