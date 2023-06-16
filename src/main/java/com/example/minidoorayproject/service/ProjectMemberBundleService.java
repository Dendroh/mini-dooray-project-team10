package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.ProjectMemberBundleDto;
import com.example.minidoorayproject.domain.ProjectMemberBundlePostReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberBundleService {

    List<MemberDto> selectAllMemberByProjectId(Integer projectId);

    List<MemberDto> selectAllProjectMemberBundleByTitle(String projectTitle);

    List<ProjectDto> selectAllProjectBundleByEmail(String memberEmail);

    ProjectMemberBundleDto createProjectMemberBundle(ProjectMemberBundlePostReq bundleDto);

    void deleteProjectMemberBundle(String deleteProjectTitle, String deleteMemberEmail);
}

