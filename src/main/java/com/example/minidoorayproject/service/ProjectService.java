package com.example.minidoorayproject.service;


import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setProjectTitle(updatedProject.getProjectTitle());
                    project.setProjectStatus(updatedProject.getProjectStatus());
                    return projectRepository.save(project);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(int id) {
        return projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}