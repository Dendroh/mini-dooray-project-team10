package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectResp {
    private Integer projectId;

    private String projectTitle;

    private String codeName;

    private String adminEmail;
}
