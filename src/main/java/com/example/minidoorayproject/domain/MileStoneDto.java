package com.example.minidoorayproject.domain;

import com.example.minidoorayproject.entity.Project;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MileStoneDto {
    private Integer milestoneId;

    @NotBlank
    private String milestoneName;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    @NotNull
    private Integer projectId;
}