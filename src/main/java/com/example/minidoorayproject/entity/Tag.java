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
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "tag_color")
    private String tagColor;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
