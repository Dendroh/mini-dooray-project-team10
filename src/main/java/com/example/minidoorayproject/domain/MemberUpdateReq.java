package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberUpdateReq {
    @NotBlank
    private String email;

    @NotBlank
    private String newName;

    @NotBlank
    private String newEmail;
}
