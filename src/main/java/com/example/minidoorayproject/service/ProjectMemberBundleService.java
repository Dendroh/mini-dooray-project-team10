package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectMemberBundleDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberBundleService {


    ProjectMemberBundleDto selectAllProjectMemberBundleByTitle(String projectTitle);

    ProjectMemberBundleDto selectAllProjectMemberBundleByEmail(String memberEmail);

    ProjectMemberBundleDto createProjectMemberBundle(int projectId, int memberId);

    ProjectMemberBundleDto updateProjectMemberBundle(ProjectMemberBundleDto projectMemberBundleDto);

    void deleteProjectMemberBundle(int id);
}

