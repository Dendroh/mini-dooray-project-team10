package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.service.ProjectMemberBundleService;
import com.example.minidoorayproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMemberBundleService projectMemberBundleService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable int id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project updatedProject) {
        return projectService.updateProject(id, updatedProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }

    // Additional endpoint for adding a member to a project
    @PostMapping("/{projectId}/member")
    public ProjectMemberBundle addProjectMember(@PathVariable int projectId, @RequestBody Member member) {
        Project project = getProjectById(projectId);
        ProjectMemberBundle projectMemberBundle = new ProjectMemberBundle();
        projectMemberBundle.setProject(project);
        projectMemberBundle.setMember(member);
        return projectMemberBundleService.saveProjectMemberBundle(projectMemberBundle);
    }

    // Additional endpoints for fetching project members
    @GetMapping("/{projectId}/members")
    public List<ProjectMemberBundle> getProjectMembers(@PathVariable int projectId) {
        return projectMemberBundleService.getProjectMemberBundlesByProjectId(projectId);
    }
}
