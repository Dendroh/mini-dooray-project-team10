package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MemberDto {

  private Integer memberId;

  private String memberName;

  private String memberEmail;


}
