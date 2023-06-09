package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ProjectDto {
    @NotNull
    private int projectId;
    private String projectTitle;
    @NotNull
    private int codeId;
    @NotNull
    private int adminId;
}






