package com.example.minidoorayproject.service;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ProjectMemberBundleService {

        @Autowired
        private ProjectMemberBundleRepository projectMemberBundleRepository;

        public ProjectMemberBundle saveProjectMemberBundle(ProjectMemberBundle projectMemberBundle) {
            return projectMemberBundleRepository.save(projectMemberBundle);
        }

        public List<ProjectMemberBundle> getProjectMemberBundlesByProjectId(int projectId) {
            return projectMemberBundleRepository.findByProject_ProjectId(projectId);
        }

        public List<ProjectMemberBundle> getProjectMemberBundlesByMemberId(int memberId) {
            return projectMemberBundleRepository.findByMember_MemberId(memberId);
        }
    }
