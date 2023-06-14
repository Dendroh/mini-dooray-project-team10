package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MileStoneDto;
import java.util.List;

public interface MileStoneService {
    MileStoneDto getMilestoneById(Integer milestoneId);

    List<MileStoneDto> getAllMilestones();

    MileStoneDto createMilestone(MileStoneDto milestoneDto);

    MileStoneDto updateMilestone(MileStoneDto milestoneDto);

    void deleteMilestone(Integer milestoneId);
}