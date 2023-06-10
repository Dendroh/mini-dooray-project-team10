package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.ProjectMemberBundleDto;
import com.example.minidoorayproject.domain.ProjectMemberBundlePostReq;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.exception.NotFoundMemberException;
import com.example.minidoorayproject.exception.NotFoundProjectException;
import com.example.minidoorayproject.exception.NotFoundProjectMemberBundleException;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.ProjectMemberBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectMemberBundleServiceImpl implements ProjectMemberBundleService {

    private final ProjectMemberBundleRepository projectMemberBundleRepository;

    private final MemberRepository memberRepository;

    private final ProjectRepository projectRepository;

    @Override
    public List<MemberDto> selectAllProjectMemberBundleByTitle(String projectTitle) {

        Project projectByTitle = projectRepository.findByProjectTitle(projectTitle);

        if (Objects.isNull(projectByTitle))
            throw new NotFoundProjectException(projectTitle);

        List<ProjectMemberBundle> bundles = projectMemberBundleRepository.findByProject_ProjectId(projectByTitle.getProjectId());

        if (bundles.isEmpty())
            throw new NotFoundProjectMemberBundleException();

        return bundles.stream()
                .map(ProjectMemberBundle::getMember)
                .map(MemberServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDto> selectAllProjectBundleByEmail(String memberEmail) {

        Member memberByEmail = memberRepository.findByMemberEmail(memberEmail);

        if (Objects.isNull(memberByEmail))
            throw new NotFoundMemberException(memberEmail);

        List<ProjectMemberBundle> bundles = projectMemberBundleRepository.findByMember_MemberEmail(memberByEmail.getMemberEmail());

        if (Objects.isNull(bundles))
            throw new NotFoundProjectMemberBundleException();

        return bundles.stream()
                .map(ProjectMemberBundle::getProject)
                .map(ProjectServiceImpl::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectMemberBundleDto createProjectMemberBundle(ProjectMemberBundlePostReq bundleDto) {

        Project project = projectRepository.findByProjectTitle(bundleDto.getProjectTitle());
        Member member = memberRepository.findByMemberEmail(bundleDto.getMemberEmail());

        if (Objects.isNull(project))
            throw new NotFoundProjectException(bundleDto.getProjectTitle());

        if (Objects.isNull(member))
            throw new NotFoundMemberException(bundleDto.getMemberEmail());

        ProjectMemberBundle bundle  = new ProjectMemberBundle();
        bundle.setMember(member);
        bundle.setProject(project);
        bundle.setRegisterTime(LocalDateTime.now());

        projectMemberBundleRepository.saveAndFlush(bundle);

        return convertToDto(bundle);
    }

    @Override
    public void deleteProjectMemberBundle(String deleteProjectTitle, String deleteMemberEmail) {
        ProjectMemberBundle bundle = projectMemberBundleRepository
                .findByMember_MemberEmailAndProject_ProjectTitle(deleteMemberEmail, deleteProjectTitle);

        if (Objects.isNull(bundle))
            throw new NotFoundProjectMemberBundleException();

        projectMemberBundleRepository.deleteById(bundle.getPMpk());
    }

    public static ProjectMemberBundleDto convertToDto(ProjectMemberBundle bundle) {
        return new ProjectMemberBundleDto(bundle.getPMpk().getProjectId(), bundle.getPMpk().getMemberId(),
                bundle.getProject().getProjectTitle(), bundle.getMember().getMemberEmail());
    }

}
