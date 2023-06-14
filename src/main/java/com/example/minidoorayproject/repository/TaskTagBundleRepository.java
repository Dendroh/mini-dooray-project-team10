package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.TaskTagBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskTagBundleRepository extends JpaRepository<TaskTagBundle, Integer> {
    List<TaskTagBundle> findByTask_TaskId(Integer taskId);

    List<TaskTagBundle> findByTag_TagId(Integer tagId);

    TaskTagBundle findByTask_TaskIdAndTag_TagId(Integer taskId, Integer tagId);

    @Override
    <S extends TaskTagBundle> S saveAndFlush(S entity);
}
