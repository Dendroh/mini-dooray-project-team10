package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.TagDto;
import com.example.minidoorayproject.entity.Tag;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.TagRepository;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.TagInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagInterface {

    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<TagDto> selectAllTagBy(String projectId) {
        List<Tag> tags = tagRepository.findAllByProject_ProjectId(Integer.parseInt(projectId));

        return tags.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createTagBy(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setTagName(tagDto.getTagName());
        tag.setTagColor(tagDto.getTagColor());

        // Retrieve the project
        Project project = projectRepository.findById(tagDto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", tagDto.getProjectId()));

        // Set the project reference
        tag.setProject(project);

        tagRepository.save(tag);
    }

    @Override
    public void updateTagBy(TagDto tagDto) {
        Tag tag = tagRepository.findById(tagDto.getTagId())
                .orElseThrow(() -> new ResourceNotFoundException("Tag", "id", tagDto.getTagId()));

        tag.setTagName(tagDto.getTagName());
        tag.setTagColor(tagDto.getTagColor());
        // Update other fields if needed

        tagRepository.save(tag);
    }

    @Override
    public void deleteTagBy(String tagId) {
        Tag tag = tagRepository.findById(Integer.valueOf(tagId))
                .orElseThrow(() -> new ResourceNotFoundException("Tag", "id", tagId));

        tagRepository.delete(tag);
    }

    private TagDto convertToDto(Tag tag) {
        return new TagDto(tag.getTagId(), tag.getTagName(), tag.getTagColor(), tag.getProject().getProjectId());

    }
}
