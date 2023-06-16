package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDtoResp {
    private Integer taskId;

    private String taskTitle;

    private String taskContent;

    private LocalDateTime writeTime;

    private String writerName;

    private String writerEmail;

    private Integer projectId;
}
