package com.example.minidoorayproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int milestoneId;

    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
