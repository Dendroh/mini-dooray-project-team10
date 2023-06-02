package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_milestone_bundle")
public class TaskMileStoneBundle {

    @ManyToOne
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;


}