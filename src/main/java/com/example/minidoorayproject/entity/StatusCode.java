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
    private int codeId;

    private String statusName;

}
