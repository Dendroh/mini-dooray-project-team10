package com.example.minidoorayproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long tagId;

    private String tagName;

    private String tagColor;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
