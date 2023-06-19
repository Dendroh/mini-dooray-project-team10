package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TagUpdateReq {
    @NotNull
    private Integer tagId;

    private String tagName;

    private String tagColor;

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setTagColor(String color) {
        this.tagColor = color;
    }
}
