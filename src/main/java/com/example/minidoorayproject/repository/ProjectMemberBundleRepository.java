package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.ProjectMemberBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectMemberBundleRepository extends JpaRepository<ProjectMemberBundle, Integer> {
}

