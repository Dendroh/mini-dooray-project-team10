package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TagPostReq {
    private String tagName;
    private String tagColor;
    @NotNull
    private Integer projectId;
}
