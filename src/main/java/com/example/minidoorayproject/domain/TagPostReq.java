package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class TagPostReq {
    @NotBlank
    private String tagName;
    private String tagColor;
    @NotNull
    private Integer projectId;

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setTagColor(String color) {
        this.tagColor = color;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
