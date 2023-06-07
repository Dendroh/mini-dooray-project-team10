package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberBundleRepository extends JpaRepository<ProjectMemberBundle, ProjectMemberBundlePk> {


    List<ProjectMemberBundle> findByProject_ProjectId(int projectId);
    List<ProjectMemberBundle> findByMember_MemberId(int memberId);


}

