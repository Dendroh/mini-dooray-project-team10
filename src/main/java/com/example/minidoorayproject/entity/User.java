package com.example.minidoorayproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {
  @Id
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "id")
  private String id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;
}
