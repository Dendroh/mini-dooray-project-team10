package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TaskDto {

    @NotNull
    private Integer taskId;

    private String taskName;

    private String content;

    private LocalDateTime writeTime;

    private Project project;

    private Member writer;
}
