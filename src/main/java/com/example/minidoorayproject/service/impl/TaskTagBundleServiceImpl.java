package com.example.minidoorayproject.service.impl;


import com.example.minidoorayproject.domain.TaskTagBundleDto;
import com.example.minidoorayproject.domain.TaskTagBundlePostReq;
import com.example.minidoorayproject.entity.Task;
import com.example.minidoorayproject.entity.TaskTagBundle;
import com.example.minidoorayproject.entity.Tag;
import com.example.minidoorayproject.repository.TaskRepository;
import com.example.minidoorayproject.repository.TagRepository;
import com.example.minidoorayproject.repository.TaskTagBundleRepository;
import com.example.minidoorayproject.service.TaskTagBundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskTagBundleServiceImpl implements TaskTagBundleService {

    private final TaskTagBundleRepository taskTagBundleRepository;
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Autowired
    public TaskTagBundleServiceImpl(TaskTagBundleRepository taskTagBundleRepository, TaskRepository taskRepository, TagRepository tagRepository) {
        this.taskTagBundleRepository = taskTagBundleRepository;
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TaskTagBundleDto> selectAllTagsByTaskName(String taskName) {
        Task task = taskRepository.findByTaskName(taskName);
        List<TaskTagBundle> bundles = taskTagBundleRepository.findByTask_TaskId(task.getTaskId());
        return bundles.stream()
                .map(bundle -> new TaskTagBundleDto(bundle.getTask().getTaskId(), bundle.getTag().getTagId(), bundle.getTask().getTaskName(), bundle.getTag().getTagName()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskTagBundleDto createTaskTagBundle(TaskTagBundlePostReq bundleDto) {
        Task task = taskRepository.findByTaskName(bundleDto.getTaskName());
        Tag tag = tagRepository.findByTagName(bundleDto.getTagName());

        TaskTagBundle bundle = new TaskTagBundle();
        bundle.setTask(task);
        bundle.setTag(tag);
        taskTagBundleRepository.saveAndFlush(bundle);

        return new TaskTagBundleDto(task.getTaskId(), tag.getTagId(), task.getTaskName(), tag.getTagName());
    }

    @Override
    public void deleteTaskTagBundle(String taskName, String tagName) {
        Task task = taskRepository.findByTaskName(taskName);
        Tag tag = tagRepository.findByTagName(tagName);
        TaskTagBundle bundle = taskTagBundleRepository.findByTask_TaskIdAndTag_TagId(task.getTaskId(), tag.getTagId());
        if (bundle == null) {
            throw new RuntimeException("Not found");
        }
        taskTagBundleRepository.delete(bundle);
    }
}

