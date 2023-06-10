package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.TaskTagBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskTagBundleRepository extends JpaRepository<TaskTagBundle, Integer> {
}
