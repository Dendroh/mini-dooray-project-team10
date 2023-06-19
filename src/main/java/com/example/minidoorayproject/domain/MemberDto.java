package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MemberDto {
  @NotNull
  private Integer memberId;

  private String memberName;

  private String memberEmail;


}
