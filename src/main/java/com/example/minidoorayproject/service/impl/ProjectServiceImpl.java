package com.example.minidoorayproject.service.impl;


import com.example.minidoorayproject.domain.*;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.exception.NotFoundMemberException;
import com.example.minidoorayproject.exception.NotFoundProjectException;
import com.example.minidoorayproject.exception.NotFoundStatusCodeException;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.repository.StatusCodeRepository;
import com.example.minidoorayproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final MemberRepository memberRepository;

    private final StatusCodeRepository codeRepository;

    @Override
    public ProjectDto createProjectBy(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectId(projectDto.getProjectId());
        project.setProjectTitle(projectDto.getProjectTitle());

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeId(projectDto.getCodeId());
        project.setProjectStatus(statusCode);

        Member admin = new Member();
        admin.setMemberId(projectDto.getCodeId());
        project.setAdmin(admin);

        project = projectRepository.save(project);

        return convertToDto(project);
    }

    @Override
    public ProjectResp createProjectByPostReq(ProjectPostReq postReq) {
        Member memberByEmail = memberRepository.findByMemberEmail(postReq.getAdminEmail());

        if (Objects.isNull(memberByEmail))
            throw new NotFoundMemberException(postReq.getAdminEmail());

        Project project = new Project();
        project.setProjectTitle(postReq.getProjectTitle());
        project.setProjectStatus(codeRepository.findByCodeId(1));
        project.setAdmin(memberByEmail);

        projectRepository.saveAndFlush(project);

        if (Objects.isNull(projectRepository.findByProjectTitle(postReq.getProjectTitle())))
            return convertToResp(project);
        else
            return null;
    }


    @Override
    public ProjectDto getProjectById(Integer id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));

        return convertToDto(project);
    }

    @Override
    public List<ProjectResp> getProjectByAdminEmail(String email) {
        List<ProjectDtoImpl> projectDtoList = projectRepository.findByAdmin_MemberEmail(email);

        if (projectDtoList.isEmpty())
            throw new NotFoundProjectException("admin email: " + email);

        return projectDtoList.stream()
                .map(ProjectServiceImpl::convertToResp)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProjectDto> selectAllProjectBy(String accountId) {
        List<Project> projects = projectRepository.findAllByAdmin_MemberId(accountId);

        return projects.stream()
                .map(ProjectServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProjectDto updateProjectBy(Integer id, ProjectDto projectDto) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project Id:" + id));

        existingProject.setProjectTitle(projectDto.getProjectTitle());
        // ... set other properties

        existingProject = projectRepository.save(existingProject);

        return convertToDto(existingProject);
    }

    @Override
    @Transactional
    public ProjectResp updateProjectByTitle(ProjectUpdateReq updateReq) {
        ProjectDtoImpl projectByTitle = projectRepository.getByProjectTitle(updateReq.getProjectTitle());
        StatusCode statusCodeByName = codeRepository.findByCodeName(updateReq.getNewStatusName());

        if (Objects.isNull(projectByTitle))
            throw new NotFoundProjectException(updateReq.getProjectTitle());

        if (Objects.isNull(statusCodeByName))
            throw new NotFoundStatusCodeException(updateReq.getNewStatusName());

        projectByTitle.setProjectTitle(updateReq.getNewProjectTitle());
        projectByTitle.setProjectStatus(statusCodeByName);

        return convertToResp(projectRepository.updateProject(projectByTitle));
    }

    @Override
    @Transactional
    public void deleteProject(Integer id) {
        if (!projectRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid project Id:" + id);
        }
        projectRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteProject(String title) {
        Project project = projectRepository.findByProjectTitle(title);

        if (Objects.isNull(project))
            throw new NotFoundProjectException(title);

        projectRepository.deleteById(project.getProjectId());
    }

    public static ProjectDto convertToDto(Project project) {
        return new ProjectDto(project.getProjectId(),project.getProjectTitle(),project.getProjectStatus().getCodeId(),project.getAdmin().getMemberId());
    }

    public static ProjectResp convertToResp(ProjectDtoImpl projectDto) {
        ProjectResp resp = new ProjectResp();
        resp.setProjectId(projectDto.getProjectId());
        resp.setProjectTitle(projectDto.getProjectTitle());
        resp.setCodeName(resp.getCodeName());
        resp.setAdminEmail(resp.getAdminEmail());

        return resp;
    }

    public static ProjectResp convertToResp(Project project) {
        ProjectResp resp = new ProjectResp();
        resp.setProjectId(project.getProjectId());
        resp.setProjectTitle(project.getProjectTitle());
        resp.setCodeName(resp.getCodeName());
        resp.setAdminEmail(resp.getAdminEmail());

        return resp;
    }

    public static Project convertToEntity(ProjectDtoImpl projectDto) {
        Project project = new Project();
        project.setProjectId(project.getProjectId());
        project.setProjectStatus(projectDto.getProjectStatus());
        project.setAdmin(projectDto.getAdmin());
        project.setProjectTitle(projectDto.getProjectTitle());

        return project;
    }

}
