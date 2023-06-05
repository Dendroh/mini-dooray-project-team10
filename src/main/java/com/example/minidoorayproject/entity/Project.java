package com.example.minidoorayproject.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int projectId;

    @Column(name = "project_title")
    private String projectTitle;

    @ManyToOne
    @JoinColumn(name = "project_status_code_id")
    private StatusCode projectStatus;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Member admin;


}