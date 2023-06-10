package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.TaskMileStoneBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskMilestoneBundleRepository extends JpaRepository<TaskMileStoneBundle, Integer> {
}
