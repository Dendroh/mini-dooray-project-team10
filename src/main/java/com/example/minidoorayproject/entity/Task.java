package com.example.minidoorayproject.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "task_name")
    private String taskName;

    private String content;

    @Column(name = "write_time")
    private LocalDateTime writeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_project_id", referencedColumnName = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_writer_id", referencedColumnName = "member_id")
    private Member writer;


}
