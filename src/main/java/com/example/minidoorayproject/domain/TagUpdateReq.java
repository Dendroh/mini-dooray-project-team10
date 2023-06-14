package com.example.minidoorayproject.domain;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class TagUpdateReq {
    @NotNull
    private Integer tagId;

    private String tagName;

    private String tagColor;
}
