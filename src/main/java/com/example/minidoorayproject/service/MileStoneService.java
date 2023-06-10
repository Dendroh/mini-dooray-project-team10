package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MileStoneDto;
import java.util.List;

public interface MileStoneService {
    List<MileStoneDto> selectAllMileStoneBy(String projectId);
    void createMileStoneBy(MileStoneDto mileStoneDto);
    void updateMileStoneBy(MileStoneDto mileStoneDto);
    void deleteMileStoneBy(String mileStoneId);
}