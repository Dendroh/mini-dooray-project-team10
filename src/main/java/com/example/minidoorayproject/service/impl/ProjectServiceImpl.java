package com.example.minidoorayproject.service.impl;


import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;




    @Override
    public ProjectDto createProjectBy(ProjectDto projectDto) {
        Project project = new Project();
        // Populate the project entity from dto
        // Assume you have corresponding setter methods in Project class
        project.setProjectTitle(projectDto.getProjectTitle());
        // ... set other properties

        project = projectRepository.save(project);

        return convertToDto(project);
    }

    @Override
    public ProjectDto getProjectById(int id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));

        return convertToDto(project);
    }

    @Override
    public List<ProjectDto> selectAllProjectBy(String accountId) {
        List<Project> projects = projectRepository.findAllByAdmin_MemberId(accountId);

        return projects.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProjectBy(int id, ProjectDto projectDto) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));

        existingProject.setProjectTitle(projectDto.getProjectTitle());
        // ... set other properties

        existingProject = projectRepository.save(existingProject);

        return convertToDto(existingProject);
    }

    @Override
    public void deleteProject(int id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid project Id:" + id);
        }
        projectRepository.deleteById(id);
    }

    private ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        // Populate the dto from the project entity
        // Assume you have corresponding getter methods in Project class
        projectDto.setProjectTitle(project.getProjectTitle());
        // ... get other properties

        return projectDto;
    }
}