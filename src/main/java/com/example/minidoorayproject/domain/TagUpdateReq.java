package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TagUpdateReq {
    @NotNull
    private Integer tagId;

    private String tagName;

    private String tagColor;

    public void setTagId(int i) {
        tagId = i;
    }

    public void setTagName(String tag1) {
        this.tagName = tag1;
    }

    public void setTagColor(String blue) {
        this.tagColor = blue;
    }
}
