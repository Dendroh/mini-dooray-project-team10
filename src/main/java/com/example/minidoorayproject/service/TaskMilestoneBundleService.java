package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundleDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundlePostReq;

import java.util.List;

public interface TaskMilestoneBundleService {

    List<MileStoneDto> selectAllMilestoneByTaskName(String taskName);

    List<TaskDto> selectAllTaskByMilestoneName(String milestoneName);

    TaskMilestoneBundleDto createTaskMilestoneBundle(TaskMilestoneBundlePostReq bundleDto);

    void deleteTaskMilestoneBundle(String taskName, String milestoneName);

}
