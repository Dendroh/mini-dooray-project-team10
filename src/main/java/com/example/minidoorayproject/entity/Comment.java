package com.example.minidoorayproject.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "comment_id")
    private int commentId;

    private String content;
    @Column(name = "write_time")
    private LocalDateTime writeTime;

    @ManyToOne
    @JoinColumn(name = "comment_task_id", referencedColumnName = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "member_writer_id", referencedColumnName = "member_id")
    private Member writer;


}
