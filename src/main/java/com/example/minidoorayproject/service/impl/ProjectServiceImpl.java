package com.example.minidoorayproject.service.impl;


import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
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
        project.setProjectId(projectDto.getProjectId());
        project.setProjectTitle(projectDto.getProjectTitle());

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeId(projectDto.getCodeId());
        project.setProjectStatus(statusCode);

        Member admin = new Member();
        admin.setMemberId(projectDto.getAdminId());
        project.setAdmin(admin);

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
                .map(ProjectServiceImpl::convertToDto)
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

    public static ProjectDto convertToDto(Project project) {
        return new ProjectDto(project.getProjectId(),project.getProjectTitle(),project.getProjectStatus().getCodeId(),project.getAdmin().getMemberId());
    }
}
