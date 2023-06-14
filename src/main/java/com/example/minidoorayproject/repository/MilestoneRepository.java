package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Integer> {
    List<Milestone> findAllByProject_ProjectId(Integer parseInt);

    Milestone findByMilestoneId(Integer id);

    Milestone findByMilestoneName(String milestoneName);

}
