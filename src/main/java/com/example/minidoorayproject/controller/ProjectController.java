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

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<ProjectDto>> getProjectsByAccount(@PathVariable String accountId) {
        List<ProjectDto> projects = projectService.selectAllProjectBy(accountId);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/account/email/{adminEmail}")
    public List<ProjectResp> getProjectsByAdminEmail(@PathVariable String adminEmail) {
        return projectService.getProjectByAdminEmail(adminEmail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProjectBy(id, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @PutMapping("/")
    public ProjectResp updateProjectByTitle(@Valid @RequestBody ProjectUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return projectService.updateProjectByTitle(updateReq);
    }

    @DeleteMapping("/title/{title}")
    public void deleteProjectByTitle(@PathVariable("title") String title) {
        projectService.deleteProject(title);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
