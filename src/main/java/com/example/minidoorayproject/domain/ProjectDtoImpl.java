package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDtoImpl {
    private Integer projectId;

    private String projectTitle;

    private StatusCode projectStatus;

    private Member admin;
}
