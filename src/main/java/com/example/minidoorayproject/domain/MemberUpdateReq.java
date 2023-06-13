package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberUpdateReq {
    private String email;
    private String newName;
    private String newEmail;
}
