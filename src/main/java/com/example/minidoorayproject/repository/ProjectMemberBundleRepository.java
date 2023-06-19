package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberBundleRepository extends JpaRepository<ProjectMemberBundle, ProjectMemberBundlePk> {

    List<ProjectMemberBundle> findByMember_MemberEmail(String email);

    List<ProjectMemberBundle> findByProject_ProjectId(Integer projectId);

    ProjectMemberBundle findByMember_MemberEmailAndProject_ProjectTitle(String memberEmail, String projectTitle);

    @Override
    <S extends ProjectMemberBundle> S saveAndFlush(S entity);
}

