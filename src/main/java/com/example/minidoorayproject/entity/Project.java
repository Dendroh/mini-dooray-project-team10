package com.example.minidoorayproject.entity;


import com.example.minidoorayproject.domain.ProjectDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "project")
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "project_title")
    private String projectTitle;

    @ManyToOne
    @JoinColumn(name = "project_status_code_id", referencedColumnName = "code_id")
    private StatusCode projectStatus;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "member_id")
    private Member admin;

}
