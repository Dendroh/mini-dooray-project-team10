package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int taskId;

    private String taskName;

    private String content;

    private LocalDateTime writeTime;

    @ManyToOne
    @JoinColumn(name = "task_project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "member_writer_id")
    private Member writer;


}