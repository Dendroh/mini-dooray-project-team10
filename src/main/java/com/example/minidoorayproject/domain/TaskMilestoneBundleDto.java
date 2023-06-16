package com.example.minidoorayproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class TaskMilestoneBundleDto {
        private int taskId;

        private int milestoneId;

        private String taskName;

        private String milestoneName;

}
