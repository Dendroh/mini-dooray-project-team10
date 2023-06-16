package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProjectMemberBundlePostReq {
    @NotBlank
    private String projectTitle;

    @NotBlank
    private String memberEmail;
}
