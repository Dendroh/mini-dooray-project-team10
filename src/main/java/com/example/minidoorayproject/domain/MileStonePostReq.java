package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class MileStonePostReq {
    @NotBlank
    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    @NotNull
    private Integer projectId;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
