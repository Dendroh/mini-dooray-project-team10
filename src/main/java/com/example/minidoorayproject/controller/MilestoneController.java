package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.domain.MileStonePostReq;
import com.example.minidoorayproject.domain.MilestoneResp;
import com.example.minidoorayproject.domain.MilestoneUpdateReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MilestoneController {
    private final MileStoneService milestoneService;

    @GetMapping("/milestones/{id}")
    public ResponseEntity<MileStoneDto> getMilestone(@PathVariable Integer id) {
        MileStoneDto milestone = milestoneService.getMilestoneById(id);
        return ResponseEntity.ok(milestone);
    }

    @GetMapping("/milestones/project/{id}")
    public List<MilestoneResp> getMilestoneByDto(@PathVariable("id") Integer projectId) {
        return milestoneService.getMilestoneByProjectId(projectId);
    }

    @GetMapping("/milestones")
    public ResponseEntity<List<MileStoneDto>> getAllMilestones() {
        List<MileStoneDto> milestones = milestoneService.getAllMilestones();
        return ResponseEntity.ok(milestones);
    }

    @PostMapping("/milestones/")
    public MilestoneResp postMilestoneByDto(@Valid @RequestBody MileStonePostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return milestoneService.createMilestone(postReq);
    }

    @PostMapping("/milestones")
    public ResponseEntity<MileStoneDto> createMilestone(@Valid @RequestBody MileStoneDto milestoneDto, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        MileStoneDto createdMilestone = milestoneService.createMilestone(milestoneDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMilestone);
    }

    @PutMapping("/milestones/")
    public MilestoneResp updateMilestone(@Valid @RequestBody MilestoneUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return milestoneService.updateMilestone(updateReq);
    }

    @PutMapping("/milestones/{id}")
    public ResponseEntity<MileStoneDto> updateMilestone(@PathVariable Integer id, @RequestBody MileStoneDto milestoneDto) {
        if(id != milestoneDto.getMilestoneId()) {
            throw new IllegalArgumentException("Milestone ID in the path and in the request body must be the same.");
        }
        MileStoneDto updatedMilestone = milestoneService.updateMilestone(milestoneDto);
        return ResponseEntity.ok(updatedMilestone);
    }

    @DeleteMapping("/milestones/{id}")
    public ResponseEntity<Void> deleteMilestone(@PathVariable Integer id) {
        milestoneService.deleteMilestone(id);
        return ResponseEntity.noContent().build();
    }
}
