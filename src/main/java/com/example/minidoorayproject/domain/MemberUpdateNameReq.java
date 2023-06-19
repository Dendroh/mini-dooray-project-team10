package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberUpdateNameReq {
    @NotBlank
    private String email;

    @NotBlank
    private String newName;
}
