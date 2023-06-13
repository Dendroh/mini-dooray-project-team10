package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.TaskDto;
import com.example.minidoorayproject.domain.TaskDtoResp;
import com.example.minidoorayproject.domain.TaskPostReq;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.Task;
import com.example.minidoorayproject.exception.NotFoundMemberException;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.repository.ProjectMemberBundleRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.repository.TaskRepository;
import com.example.minidoorayproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final MemberRepository memberRepository;

    private final ProjectRepository projectRepository;

    private final ProjectMemberBundleRepository bundleRepository;


    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task", "id", id));
    }

    public Task updateTask(int id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTaskName(updatedTask.getTaskName());
                    task.setContent(updatedTask.getContent());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    updatedTask.setTaskId(id);
                    return taskRepository.save(updatedTask);
                });
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDtoResp> getTasksByProjectId(Integer projectId) {
        List<TaskDto> taskDtoList = taskRepository.getByProject_ProjectId(projectId);

        return taskDtoList.stream()
                .map(TaskServiceImpl::convertToResp)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDtoResp> getTasksByMemberEmail(String email) {
        Member member = memberRepository.findByMemberEmail(email);

        if (Objects.isNull(member))
            throw new NotFoundMemberException(email);

        List<Integer> projectIds = bundleRepository.findByMember_MemberEmail(member.getMemberEmail()).stream()
                .map(ProjectMemberBundle::getProject)
                .map(Project::getProjectId)
                .collect(Collectors.toList());

        List<TaskDto> tasks = new ArrayList<>();

        for (Integer projectId : projectIds) {
            tasks.addAll(taskRepository.getByProject_ProjectId(projectId));
        }

        return tasks.stream()
                .map(TaskServiceImpl::convertToResp)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDtoResp createTaskByDto(TaskPostReq postReq) {
        Task task = new Task();
        task.setTaskName(postReq.getTaskName());
        task.setContent(postReq.getContent());
        task.setProject(projectRepository.findByProjectId(postReq.getProjectId()));
        task.setWriter(memberRepository.findByMemberEmail(postReq.getWriterEmail()));
        task.setWriteTime(LocalDateTime.now().plusHours(9));

        return convertToResp(taskRepository.saveAndFlush(task));
    }

    public static TaskDto convertToDto(Task task) {
        return new TaskDto(task.getTaskId(), task.getTaskName(), task.getContent(), task.getWriteTime(), task.getProject(), task.getWriter());
    }

    public static TaskDtoResp convertToResp(TaskDto taskDto) {
        TaskDtoResp resp = new TaskDtoResp();
        resp.setTaskId(taskDto.getTaskId());
        resp.setTaskName(taskDto.getTaskName());
        resp.setContent(taskDto.getContent());
        resp.setWriterEmail(taskDto.getWriter().getMemberEmail());
        resp.setWriteTime(taskDto.getWriteTime());
        resp.setWriterName(taskDto.getWriter().getMemberName());
        resp.setProjectId(taskDto.getProject().getProjectId());
        return resp;
    }

    public static TaskDtoResp convertToResp(Task task) {
        TaskDtoResp resp = new TaskDtoResp();
        resp.setTaskId(task.getTaskId());
        resp.setTaskName(task.getTaskName());
        resp.setContent(task.getContent());
        resp.setWriterEmail(task.getWriter().getMemberEmail());
        resp.setWriteTime(task.getWriteTime());
        resp.setWriterName(task.getWriter().getMemberName());
        resp.setProjectId(task.getProject().getProjectId());
        return resp;
    }
}