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
@Table(name = "milestone")
public class Milestone {
    @Id
    @Column(name = "milestone_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int milestoneId;

    @Column(name = "milestone_name")
    private String milestoneName;

    @Column(name = "start_datetime")
    private LocalDateTime startDatetime;

    @Column(name = "end_datetime")
    private LocalDateTime endDatetime;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
