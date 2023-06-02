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
@Table(name = "Member")
@NoArgsConstructor
public class Member {
  @Id
  @Column(name = "member_id")
  private Integer memberId;

  @Column(name = "member_name")
  private String memberName;

  @Column(name = "member_email")
  private String memberEmail;
}
