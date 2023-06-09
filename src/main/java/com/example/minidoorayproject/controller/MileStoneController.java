package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dooray/project/milestone")
@RequiredArgsConstructor
public class MileStoneController {

    private final MileStoneService mileStoneService;

    @GetMapping("/{projectId}")
    public ResponseEntity<List<MileStoneDto>> getAllMileStones(@PathVariable String projectId) {
        List<MileStoneDto> mileStones = mileStoneService.selectAllMileStoneBy(projectId);
        return ResponseEntity.ok(mileStones);
    }

    @PostMapping
    public ResponseEntity<Void> createMileStone(@RequestBody MileStoneDto mileStoneDto) {
        mileStoneService.createMileStoneBy(mileStoneDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMileStone(@RequestBody MileStoneDto mileStoneDto) {
        mileStoneService.updateMileStoneBy(mileStoneDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{mileStoneId}")
    public ResponseEntity<Void> deleteMileStone(@PathVariable String mileStoneId) {
        mileStoneService.deleteMileStoneBy(mileStoneId);
        return ResponseEntity.noContent().build();
    }
}
