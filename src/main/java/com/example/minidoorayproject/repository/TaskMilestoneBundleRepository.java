package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.TaskMileStoneBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskMilestoneBundleRepository extends JpaRepository<TaskMileStoneBundle, Integer> {
    List<TaskMileStoneBundle> findByTask_TaskId(Integer taskId);

    List<TaskMileStoneBundle> findByMilestone_MilestoneId(Integer milestoneId);

    TaskMileStoneBundle findByTask_TaskIdAndMilestone_MilestoneId(Integer taskId, Integer milestoneId);

    @Override
    <S extends TaskMileStoneBundle> S saveAndFlush(S entity);
}
