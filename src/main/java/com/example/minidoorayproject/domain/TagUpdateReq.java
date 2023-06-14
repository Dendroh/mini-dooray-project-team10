package com.example.minidoorayproject.domain;

import lombok.Getter;

@Getter
public class TagUpdateReq {
    private Integer tagId;

    private String tagName;

    private String tagColor;
}
