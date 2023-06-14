package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.MileStonePostReq;
import com.example.minidoorayproject.domain.MilestoneResp;
import com.example.minidoorayproject.domain.MilestoneUpdateReq;
import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.exception.NotFoundMileStoneException;
import com.example.minidoorayproject.exception.NotFoundProjectException;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MilestoneRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MilestoneRepository milestoneRepository;

    private final ProjectRepository projectRepository;


    @Override
    public MileStoneDto getMilestoneById(Integer milestoneId) {
        Milestone milestone = milestoneRepository.findById(milestoneId)
                .orElseThrow(NotFoundMileStoneException::new);

        return new MileStoneDto(milestone.getMilestoneId(), milestone.getMilestoneName(), milestone.getStartDatetime(), milestone.getEndDatetime(), milestone.getProject().getProjectId());
    }

    @Override
    public List<MileStoneDto> getAllMilestones() {
        return milestoneRepository.findAll().stream()
                .map(milestone -> new MileStoneDto(milestone.getMilestoneId(), milestone.getMilestoneName(), milestone.getStartDatetime(), milestone.getEndDatetime(), milestone.getProject().getProjectId()))
                .collect(Collectors.toList());
    }

    @Override
    public MileStoneDto createMilestone(MileStoneDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setStartDatetime(milestoneDto.getStartDatetime());
        milestone.setEndDatetime(milestoneDto.getEndDatetime());

        Project project = projectRepository.findById(milestoneDto.getProjectId())
                .orElseThrow(() -> new NotFoundProjectException(milestoneDto.getProjectId()));

        milestone.setProject(project);

        Milestone savedMilestone = milestoneRepository.save(milestone);

        return new MileStoneDto(savedMilestone.getMilestoneId(), savedMilestone.getMilestoneName(), savedMilestone.getStartDatetime(), savedMilestone.getEndDatetime(), savedMilestone.getProject().getProjectId());
    }

    @Override
    public MilestoneResp createMilestone(MileStonePostReq postReq) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName(postReq.getMilestoneName());
        milestone.setStartDatetime(postReq.getStartDatetime());
        milestone.setEndDatetime(postReq.getEndDatetime());
        milestone.setProject(projectRepository.findByProjectId(postReq.getProjectId()));

        return convertToResp(milestoneRepository.saveAndFlush(milestone));
    }

    @Override
    public MileStoneDto updateMilestone(MileStoneDto milestoneDto) {
        Milestone milestone = milestoneRepository.findById(milestoneDto.getMilestoneId())
                .orElseThrow(NotFoundMileStoneException::new);

        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setStartDatetime(milestoneDto.getStartDatetime());
        milestone.setEndDatetime(milestoneDto.getEndDatetime());
        // Assuming there's a method in the Milestone class to set the project using the project ID.
        Project project = projectRepository.findById(milestoneDto.getProjectId())
                .orElseThrow(() -> new NotFoundProjectException(milestoneDto.getProjectId()));

        milestone.setProject(project);

        Milestone updatedMilestone = milestoneRepository.save(milestone);

        return new MileStoneDto(updatedMilestone.getMilestoneId(), updatedMilestone.getMilestoneName(), updatedMilestone.getStartDatetime(), updatedMilestone.getEndDatetime(), updatedMilestone.getProject().getProjectId());
    }

    @Override
    @Transactional
    public MilestoneResp updateMilestone(MilestoneUpdateReq updateReq) {
        Milestone milestone = milestoneRepository.findByMilestoneId(updateReq.getMilestoneId());

        if (Objects.isNull(milestone))
            throw new NotFoundMileStoneException();

        milestone.setMilestoneName(updateReq.getMilestoneName());
        milestone.setStartDatetime(updateReq.getStartDatetime());
        milestone.setEndDatetime(updateReq.getEndDatetime());

        return convertToResp(milestone);
    }

    @Override
    @Transactional
    public void deleteMilestone(Integer milestoneId) {
        if(!milestoneRepository.existsById(milestoneId)) {
            throw new NotFoundMileStoneException();
        }

        milestoneRepository.deleteById(milestoneId);
    }

    public static MilestoneResp convertToResp(Milestone milestone) {
        return new MilestoneResp(milestone.getMilestoneId(), milestone.getMilestoneName(),
                milestone.getStartDatetime(), milestone.getEndDatetime(), milestone.getProject().getProjectId());
    }
}