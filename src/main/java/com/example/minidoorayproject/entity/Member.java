package com.example.minidoorayproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Member")
@NoArgsConstructor
public class Member {
  @Id
  @Column(name = "member_id", nullable = false, unique = true)
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer memberId;

  @Column(name = "member_name", nullable = false)
  private String memberName;

  @Column(name = "member_email", nullable = false)
  private String memberEmail;
}
