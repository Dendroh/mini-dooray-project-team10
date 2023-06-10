package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TagDto;

import java.util.List;

public interface TagInterface {
    List<TagDto> selectAllTagBy(String projectId);
    void createTagBy(TagDto tagDto);
    void updateTagBy(TagDto tagDto);
    void deleteTagBy(String tagId);
}

