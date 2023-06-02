package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "task_tag_bundle")
public class TaskTagBundle {


    @Id
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;


    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}