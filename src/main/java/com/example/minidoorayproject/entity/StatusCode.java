package com.example.minidoorayproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "status_code")
public class StatusCode {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "code_id")
    private int codeId;
    @Column(name = "status_name")
    private String statusName;

}
