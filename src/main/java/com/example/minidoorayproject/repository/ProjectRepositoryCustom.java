package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.domain.ProjectDtoImpl;
import com.example.minidoorayproject.entity.Project;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectRepositoryCustom {
    Project updateProject(ProjectDtoImpl projectDto);
}
