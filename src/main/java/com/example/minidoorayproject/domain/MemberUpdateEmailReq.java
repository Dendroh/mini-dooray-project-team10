package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberUpdateEmailReq {
    @NotBlank
    private String email;

    @NotBlank
    private String newEmail;
}
