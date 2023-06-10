package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.ProjectMemberBundleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberBundleService {


    List<MemberDto> selectAllProjectMemberBundleByTitle(String projectTitle);

    List<ProjectDto> selectAllProjectBundleByEmail(String memberEmail);

    ProjectMemberBundleDto createProjectMemberBundle(Integer projectId, Integer memberId);

    void deleteProjectMemberBundle(Integer deleteProjectId, Integer deleteMemberId);
}

