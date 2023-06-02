package com.example.minidoorayproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "project_member_bundle")
public class ProjectMemberBundle {
    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime registerTime;

}
