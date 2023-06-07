package com.example.minidoorayproject.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "status_code")
public class StatusCode {
    @Id
    @Column(name = "code_id")
    private int codeId;

    @Column(name = "status_name")
    private String codeName;


}