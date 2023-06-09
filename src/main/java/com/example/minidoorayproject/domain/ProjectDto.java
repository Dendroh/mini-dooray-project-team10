package com.example.minidoorayproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
public class ProjectDto {
    private int projectId;
    private String projectTitle;
    private int codeId;
    private int adminId;
}
