package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TagDto;
import com.example.minidoorayproject.domain.TagDtoResp;
import com.example.minidoorayproject.domain.TagPostReq;
import com.example.minidoorayproject.domain.TagUpdateReq;

import java.util.List;

public interface TagService {
    List<TagDto> selectAllTagBy(String projectId);
    void createTagBy(TagDto tagDto);
    TagDtoResp createTagByDto(TagPostReq postReq);
    TagDtoResp updateTagByDto(TagUpdateReq updateReq);
    void updateTagBy(TagDto tagDto);
    void deleteTagBy(String tagId);
}

