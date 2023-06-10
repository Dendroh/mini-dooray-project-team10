package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberBundleRepository extends JpaRepository<ProjectMemberBundle, ProjectMemberBundlePk> {
    List<ProjectMemberBundle> findByProject_ProjectTitle(String title);

    List<ProjectMemberBundle> findByMember_MemberEmail(String email);

    List<ProjectMemberBundle> findByProject_ProjectId(Integer projectId);

    List<ProjectMemberBundle> findByMember_MemberId(Integer memberId);

    ProjectMemberBundle findByMember_MemberEmailAndProject_ProjectTitle(String memberEmail, String projectTitle);

    ProjectMemberBundle findByPMpk_ProjectIdAndPMpk_MemberId(Integer projectId, Integer memberId);

    @Override
    <S extends ProjectMemberBundle> S saveAndFlush(S entity);
}

