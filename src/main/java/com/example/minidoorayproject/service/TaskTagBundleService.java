package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.TagDtoResp;
import com.example.minidoorayproject.domain.TaskTagBundleDto;
import com.example.minidoorayproject.domain.TaskTagBundlePostReq;
import java.util.List;

public interface TaskTagBundleService {
    List<TagDtoResp> selectAllTagsByTaskName(String taskName);
    TaskTagBundleDto createTaskTagBundle(TaskTagBundlePostReq bundleDto);
    void deleteTaskTagBundle(String taskName, String tagName);
}

