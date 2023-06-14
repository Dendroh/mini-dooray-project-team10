package com.example.minidoorayproject.domain;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TaskMilestoneBundlePostReq {
    @NotBlank
    private String taskName;

    @NotBlank
    private String milestoneName;
}
