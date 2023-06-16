package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.MileStonePostReq;
import com.example.minidoorayproject.domain.MilestoneResp;
import com.example.minidoorayproject.domain.MilestoneUpdateReq;

import java.util.List;

public interface MileStoneService {
    MileStoneDto getMilestoneById(Integer milestoneId);

    List<MilestoneResp> getMilestoneByProjectId(Integer projectId);

    List<MileStoneDto> getAllMilestones();

    MileStoneDto createMilestone(MileStoneDto milestoneDto);

    MilestoneResp createMilestone(MileStonePostReq postReq);

    MileStoneDto updateMilestone(MileStoneDto milestoneDto);

    MilestoneResp updateMilestone(MilestoneUpdateReq updateReq);

    void deleteMilestone(Integer milestoneId);
}