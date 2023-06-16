package com.example.minidoorayproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MilestoneResp {
    private Integer milestoneId;

    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    private Integer projectId;
}
