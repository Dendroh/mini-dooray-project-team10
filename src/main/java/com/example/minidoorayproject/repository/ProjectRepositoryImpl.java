package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.domain.ProjectDtoImpl;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.QProject;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ProjectRepositoryImpl extends QuerydslRepositorySupport implements ProjectRepositoryCustom {

    public ProjectRepositoryImpl() {
        super(Project.class);
    }

    @Override
    public Project updateProject(ProjectDtoImpl projectDto) {
        QProject project = QProject.project;

        update(project)
                .set(project.projectTitle, projectDto.getProjectTitle())
                .set(project.projectStatus, projectDto.getProjectStatus())
                .where(project.projectId.eq(projectDto.getProjectId()))
                .execute();

        return from(project)
                .where(project.projectId.eq(projectDto.getProjectId()))
                .fetchOne();
    }
}
