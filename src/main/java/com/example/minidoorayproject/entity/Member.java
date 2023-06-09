package com.example.minidoorayproject.entity;

import lombok.*;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {
  @Id
  @Column(name = "member_id")
  private Integer memberId;

  @Column(name = "name")
  private String memberName;

  @Column(name = "email")
  private String memberEmail;

}
