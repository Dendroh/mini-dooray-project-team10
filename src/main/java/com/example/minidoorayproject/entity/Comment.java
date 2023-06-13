package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    private String content;
    @Column(name = "write_time")
    private LocalDateTime writeTime;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "comment_task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "member_writer_id")
    private Member writer;


}
