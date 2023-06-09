package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.service.ProjectService;
import com.example.minidoorayproject.service.impl.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/project")
//public class ProjectController {
//
//    @Autowired
//    private ProjectServiceImpl projectService;
//
//    @Autowired
//    private ProjectMemberBundleService projectMemberBundleService;
//
//    @PostMapping
//    public Project createProject(@RequestBody Project project) {
//        return projectService.createProject(project);
//    }
//
//    @GetMapping
//    public List<Project> getAllProjects() {
//        return projectService.getAllProjects();
//    }
//
//    @GetMapping("/{id}")
//    public Project getProjectById(@PathVariable int id) {
//        return projectService.getProjectById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Project updateProject(@PathVariable int id, @RequestBody Project updatedProject) {
//        return projectService.updateProject(id, updatedProject);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProject(@PathVariable int id) {
//        projectService.deleteProject(id);
//    }

    // Additional endpoint for adding a member to a project
////    @PostMapping("/{projectId}/member") // 프로젝트를 넘겨주는 방법.
////    public ProjectMemberBundle addProjectMember(@PathVariable int projectId, @RequestBody Member member) {
////        Project project = getProjectById(projectId);
////        ProjectMemberBundle projectMemberBundle = new ProjectMemberBundle();
////        projectMemberBundle.setProject(project);
////       projectMemberBundle.setMember(member);
////        return projectMemberBundleService.saveProjectMemberBundle(projectMemberBundle);
////    }

    // Additional endpoints for fetching project members
//    @GetMapping("/{projectId}/members")
//    public List<ProjectMemberBundle> getProjectMembers(@PathVariable int projectId) {
//        return projectMemberBundleService.getProjectMemberBundlesByProjectId(projectId);
//    }

////    @DeleteMapping("/{projectId}/member/{memberId}")
//  //  public void deleteProjectMember(@PathVariable int projectId, @PathVariable int memberId, @RequestBody ProjectMemberBundle projectMemberBundle){
//    //    projectMemberBundleService.deleteProject(projectId, memberId);
//    //}

//}
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

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable int id) {
        ProjectDto projectDto = projectService.getProjectById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<ProjectDto>> getProjectsByAccount(@PathVariable String accountId) {
        List<ProjectDto> projects = projectService.selectAllProjectBy(accountId);
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable int id, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProjectBy(id, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}

