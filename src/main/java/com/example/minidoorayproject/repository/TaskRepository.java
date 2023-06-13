package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTaskId(Integer id);

    List<Task> findByProject_ProjectId(Integer id);

}