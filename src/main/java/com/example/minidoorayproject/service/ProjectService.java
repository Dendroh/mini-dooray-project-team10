package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.ProjectDto;

import java.util.List;
public interface ProjectService {
    ProjectDto createProjectBy(ProjectDto projectDto);
    ProjectDto getProjectById(int id);
    List<ProjectDto> selectAllProjectBy(String accountId);
    ProjectDto updateProjectBy(int id, ProjectDto projectDto);
    void deleteProject(int id);


}
