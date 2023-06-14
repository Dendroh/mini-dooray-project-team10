package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class MilestoneUpdateReq {
    @NotNull
    private Integer milestoneId;
    @NotBlank
    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;
}
