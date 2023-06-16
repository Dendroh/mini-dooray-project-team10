package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberPostReq {
    @NotBlank
    private String memberName;

    @NotBlank
    private String memberEmail;
}
