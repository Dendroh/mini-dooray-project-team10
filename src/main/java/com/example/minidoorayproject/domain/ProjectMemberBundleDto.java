package com.example.minidoorayproject.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ProjectMemberBundleDto {

    private int projectId;

    private int memberId;

    private String projectTitle;

    private String memberEmail;
}
