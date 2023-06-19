package com.example.minidoorayproject.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ProjectMemberBundleDto {
    private Integer projectId;

    private Integer memberId;

    private String projectTitle;

    private String memberEmail;
}
