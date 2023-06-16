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

    public void setMilestoneId(int id) {
        milestoneId = id;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public void setStartDatetime(LocalDateTime time) {
        this.startDatetime = time;
    }

    public void setEndDatetime(LocalDateTime time) {
        this.endDatetime = time;
    }
}
