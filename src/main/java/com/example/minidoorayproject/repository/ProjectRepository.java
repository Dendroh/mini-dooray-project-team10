package com.example.minidoorayproject.repository;


import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.ProjectDtoImpl;
import com.example.minidoorayproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {

    Project findByProjectId(Integer id);

    List<Project> findAllByAdmin_MemberId(String accountId);

    Project findByProjectTitle(String projectTitle);

    ProjectDtoImpl getByProjectId(Integer projectId);
}

