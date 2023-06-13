package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TaskDto {
    private Integer taskId;

    private String taskName;

    private String content;

    private LocalDateTime writeTime;

    private Project project;

    private Member writer;
}
