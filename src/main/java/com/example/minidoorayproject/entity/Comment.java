package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentId;

    private String content;

    private LocalDateTime writeTime;

    @ManyToOne
    @JoinColumn(name = "comment_task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "member_writer_id")
    private Member writer;


}
