package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.ProjectPostReq;
import com.example.minidoorayproject.domain.ProjectResp;
import com.example.minidoorayproject.domain.ProjectUpdateReq;

import java.util.List;
public interface ProjectService {
    ProjectDto createProjectBy(ProjectDto projectDto);
    ProjectResp createProjectByPostReq(ProjectPostReq postReq);
    ProjectDto getProjectById(Integer id);
    ProjectResp findProjectById(Integer projectId);
    List<ProjectResp> getProjectByMemberEmail(String email);
    List<ProjectDto> selectAllProjectBy(Integer accountId);
    ProjectDto updateProjectBy(Integer id, ProjectDto projectDto);
    ProjectResp updateProjectById(ProjectUpdateReq updateReq);
    void deleteProject(Integer id);
}
