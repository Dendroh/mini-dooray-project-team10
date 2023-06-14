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

    public void setTagName(String tag1) {
        this.tagName = tag1;
    }

    public void setTagColor(String blue) {
        this.tagColor = blue;
    }

    public void setProjectId(int i) {
        this.projectId = i;
    }
}
