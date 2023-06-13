package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MileStoneDto {
    @NotNull
    private Integer milestoneId;

    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    @NotNull
    private Integer projectId;
}