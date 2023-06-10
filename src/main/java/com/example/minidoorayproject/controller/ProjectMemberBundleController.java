package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.service.ProjectMemberBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectMemberBundleController {
    private final ProjectMemberBundleService service;

    @GetMapping("/projects/members/{projectTitle}")
    public List<MemberDto> getMembersByProjectTitle(@PathVariable("projectTitle") String projectTitle) {
        return service.selectAllProjectMemberBundleByTitle(projectTitle);
    }

}
