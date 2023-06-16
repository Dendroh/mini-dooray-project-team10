package com.example.minidoorayproject.domain;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TaskTagBundlePostReq {

    @NotBlank
    private String taskName;

    @NotBlank
    private String tagName;
}
