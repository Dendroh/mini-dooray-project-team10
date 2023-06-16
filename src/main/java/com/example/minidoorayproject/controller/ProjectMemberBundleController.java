package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.*;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.ProjectMemberBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectMemberBundleController {
    private final ProjectMemberBundleService service;

    @GetMapping("/projects/members/id/{projectId}")
    public List<MemberDto> selectAllMemberByProjectId(@PathVariable("projectId") Integer projectId) {
        return service.selectAllMemberByProjectId(projectId);
    }

    @GetMapping("/projects/members/{projectTitle}")
    public List<MemberDto> getMembersByProjectTitle(@PathVariable("projectTitle") String projectTitle) {
        return service.selectAllProjectMemberBundleByTitle(projectTitle);
    }

    @GetMapping("/members/projects/{memberEmail}")
    public List<ProjectDto> getProjectsByMemberEmail(@PathVariable("memberEmail") String memberEmail) {
        return service.selectAllProjectBundleByEmail(memberEmail);
    }

    @PostMapping("/projects/members")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectMemberBundleDto postProjectMemberBundle(@Valid @RequestBody ProjectMemberBundlePostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return service.createProjectMemberBundle(postReq);
    }

    @DeleteMapping("/projects/members/{projectTitle}/{memberEmail}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectMemberBundle(@PathVariable("projectTitle") String projectTitle, @PathVariable("memberEmail") String memberEmail) {
        service.deleteProjectMemberBundle(projectTitle, memberEmail);
    }

}
