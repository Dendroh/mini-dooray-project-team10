package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.*;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        ProjectDto createdProject = projectService.createProjectBy(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProjectResp createProjectByDto(@Valid @RequestBody ProjectPostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return projectService.createProjectByPostReq(postReq);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Integer id) {
        ProjectDto projectDto = projectService.getProjectById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping("/id/{projectId}")
    public ProjectResp getProjectById(@PathVariable("projectId") Integer projectId) {
        return projectService.findProjectById(projectId);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<ProjectDto>> getProjectsByAccount(@PathVariable String accountId) {
        List<ProjectDto> projects = projectService.selectAllProjectBy(Integer.parseInt(accountId));
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/account/email/{memberEmail}")
    public List<ProjectResp> getProjectsByMemberEmail(@PathVariable String memberEmail) {
        return projectService.getProjectByMemberEmail(memberEmail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProjectBy(id, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @PutMapping("/")
    public ProjectResp updateProjectById(@Valid @RequestBody ProjectUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return projectService.updateProjectById(updateReq);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable("id") Integer id) {
        projectService.deleteProject(id);
    }

}
