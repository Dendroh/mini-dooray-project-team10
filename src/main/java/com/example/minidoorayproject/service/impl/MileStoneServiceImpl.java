package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.entity.Milestone;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MilestoneRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<MileStoneDto> selectAllMileStoneBy(String projectId) {
        List<Milestone> milestones = milestoneRepository.findAllByProject_ProjectId(Integer.parseInt(projectId));

        return milestones.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createMileStoneBy(MileStoneDto mileStoneDto) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName(mileStoneDto.getMilestoneName());
        milestone.setStartDatetime(mileStoneDto.getStartDatetime());
        milestone.setEndDatetime(mileStoneDto.getEndDatetime());

        // Retrieve the project
        Project project = projectRepository.findById(mileStoneDto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", mileStoneDto.getProjectId()));

        // Set the project reference
        milestone.setProject(project);

        milestoneRepository.save(milestone);
    }

    @Override
    public void updateMileStoneBy(MileStoneDto mileStoneDto) {
        Milestone milestone = milestoneRepository.findById(mileStoneDto.getMilestoneId())
                .orElseThrow(() -> new ResourceNotFoundException("Milestone", "id", mileStoneDto.getMilestoneId()));

        milestone.setMilestoneName(mileStoneDto.getMilestoneName());
        milestone.setStartDatetime(mileStoneDto.getStartDatetime());
        milestone.setEndDatetime(mileStoneDto.getEndDatetime());
        // Update other fields if needed

        milestoneRepository.save(milestone);
    }

    @Override
    public void deleteMileStoneBy(String mileStoneId) {
        Milestone milestone = milestoneRepository.findById(Integer.parseInt(mileStoneId))
                .orElseThrow(() -> new ResourceNotFoundException("Milestone", "id", mileStoneId));

        milestoneRepository.delete(milestone);
    }

    private MileStoneDto convertToDto(Milestone milestone) {
        MileStoneDto mileStoneDto = new MileStoneDto(milestone.getMilestoneId(), milestone.getMilestoneName(),
                milestone.getStartDatetime(), milestone.getEndDatetime(), milestone.getProject().getProjectId());

        return mileStoneDto;
    }
}