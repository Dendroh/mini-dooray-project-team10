package com.example.minidoorayproject.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProjectPostReq {
    @NotBlank
    private String projectTitle;

    @NotBlank
    private String adminEmail;

}
