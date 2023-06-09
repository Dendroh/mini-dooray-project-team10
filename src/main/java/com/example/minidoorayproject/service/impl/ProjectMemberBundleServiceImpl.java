package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.compositekey.ProjectMemberBundlePk;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectMemberBundleServiceImpl {

//    @Autowired
//    private ProjectMemberBundleRepository projectMemberBundleRepository;
//
//    public ProjectMemberBundle saveProjectMemberBundle(ProjectMemberBundle projectMemberBundle) {
//        return projectMemberBundleRepository.save(projectMemberBundle);
//    }
//
//    public List<ProjectMemberBundle> getProjectMemberBundlesByProjectId(int projectId) {
//        return projectMemberBundleRepository.findByProject_ProjectId(projectId);
//    }
//
//    public List<ProjectMemberBundle> getProjectMemberBundlesByMemberId(int memberId) {
//        return projectMemberBundleRepository.findByMember_MemberId(memberId);
//    }
//
//    public void deleteProject(int projectId, int memberId) {
//        ProjectMemberBundlePk id = new ProjectMemberBundlePk(projectId, memberId);
//        projectMemberBundleRepository.deleteById(id);
//    }
}
