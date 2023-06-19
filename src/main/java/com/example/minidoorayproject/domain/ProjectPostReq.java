package com.example.minidoorayproject.domain;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;


@Setter
@Getter
public class ProjectPostReq {
    @NotBlank
    private String projectTitle;

    @NotBlank
    private String adminEmail;

}
