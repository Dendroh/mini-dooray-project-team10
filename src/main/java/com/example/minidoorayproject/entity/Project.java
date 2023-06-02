package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int projectId;

    private String projectTitle;

    @ManyToOne
    @JoinColumn(name = "project_status_code_id")
    private StatusCode projectStatusCode;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Member admin;


}