package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectResp {
    private Integer projectId;

    private String projectTitle;

    private String codeName;

    private String adminEmail;

    private String adminName;
}
