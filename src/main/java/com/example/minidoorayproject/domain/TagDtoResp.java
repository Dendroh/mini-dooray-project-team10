package com.example.minidoorayproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TagDtoResp {
    private Integer tagId;

    private String tagName;

    private String tagColor;

    private Integer projectId;
}
