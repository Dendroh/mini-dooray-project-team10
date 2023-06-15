package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundleDto;
import com.example.minidoorayproject.domain.TaskMilestoneBundlePostReq;
import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Task;
import com.example.minidoorayproject.entity.TaskMileStoneBundle;
import com.example.minidoorayproject.exception.NotFoundMileStoneException;
import com.example.minidoorayproject.exception.NotFoundTaskMileStoneBundleException;
import com.example.minidoorayproject.repository.MilestoneRepository;
import com.example.minidoorayproject.repository.TaskMilestoneBundleRepository;
import com.example.minidoorayproject.repository.TaskRepository;
import com.example.minidoorayproject.service.TaskMilestoneBundleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskMilestoneBundleServiceImpl implements TaskMilestoneBundleService {

    private final TaskMilestoneBundleRepository taskMilestoneBundleRepository;
    private final TaskRepository taskRepository;
    private final MilestoneRepository milestoneRepository;

    @Override
    public List<MileStoneDto> selectAllMilestoneByTaskName(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        List<TaskMileStoneBundle> bundles = taskMilestoneBundleRepository.findByTask_TaskId(task.getTaskId());
        return bundles.stream()
                .map(bundle -> convertMilestoneToDto(bundle.getMilestone()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> selectAllTaskByMilestoneName(String milestoneName) {
        Milestone milestone = milestoneRepository.findByMilestoneName(milestoneName);

        if (Objects.isNull(milestone))
            throw new NotFoundMileStoneException();

        List<TaskMileStoneBundle> bundles = taskMilestoneBundleRepository.findByMilestone_MilestoneId(milestone.getMilestoneId());
        return bundles.stream()
                .map(bundle -> convertTaskToDto(bundle.getTask()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskMilestoneBundleDto createTaskMilestoneBundle(TaskMilestoneBundlePostReq bundleDto) {
        Task task = taskRepository.findByTaskName(bundleDto.getTaskName());
        Milestone milestone = milestoneRepository.findByMilestoneName(bundleDto.getMilestoneName());

        TaskMileStoneBundle bundle = new TaskMileStoneBundle();
        bundle.setTask(task);
        bundle.setMilestone(milestone);
        taskMilestoneBundleRepository.saveAndFlush(bundle);

        return new TaskMilestoneBundleDto(task.getTaskId(), milestone.getMilestoneId(), task.getTaskName(), milestone.getMilestoneName());
    }

    @Override
    public void deleteTaskMilestoneBundle(String taskName, String milestoneName) {
        Task task = taskRepository.findByTaskName(taskName);
        Milestone milestone = milestoneRepository.findByMilestoneName(milestoneName);
        TaskMileStoneBundle bundle = taskMilestoneBundleRepository.findByTask_TaskIdAndMilestone_MilestoneId(task.getTaskId(), milestone.getMilestoneId());
        if (bundle == null) {
            throw new NotFoundTaskMileStoneBundleException();
        }
        taskMilestoneBundleRepository.delete(bundle);
    }

    private TaskDto convertTaskToDto(Task task) {
        return new TaskDto(task.getTaskId(), task.getTaskName(), task.getContent(), task.getWriteTime(), task.getProject(), task.getWriter());
    }

    private MileStoneDto convertMilestoneToDto(Milestone milestone) {
        return new MileStoneDto(milestone.getMilestoneId(), milestone.getMilestoneName(), milestone.getStartDatetime(), milestone.getEndDatetime(), milestone.getProject().getProjectId());
    }

}
