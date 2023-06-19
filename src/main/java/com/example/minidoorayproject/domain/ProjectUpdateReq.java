package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProjectUpdateReq {
    @NotNull
    private Integer projectId;

    @NotBlank
    private String newProjectTitle;

    @NotBlank
    private String newStatusName;
}
