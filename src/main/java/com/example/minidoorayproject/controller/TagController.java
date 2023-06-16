package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.TagDto;
import com.example.minidoorayproject.domain.TagDtoResp;
import com.example.minidoorayproject.domain.TagPostReq;
import com.example.minidoorayproject.domain.TagUpdateReq;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags/{projectId}")
    public ResponseEntity<List<TagDto>> getAllTagsByProjectId(@PathVariable String projectId) {
        List<TagDto> tags = tagService.selectAllTagBy(projectId);
        return ResponseEntity.ok(tags);
    }

    @PostMapping("/tags/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TagDtoResp postTagByDto(@Valid @RequestBody TagPostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return tagService.createTagByDto(postReq);
    }

    @PostMapping("/tags")
    public ResponseEntity<Void> createTag(@RequestBody TagDto tagDto) {
        tagService.createTagBy(tagDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/tags")
    public ResponseEntity<Void> updateTag(@RequestBody TagDto tagDto) {
        tagService.updateTagBy(tagDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tags/")
    public TagDtoResp updateTagByDto(@Valid @RequestBody TagUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return tagService.updateTagByDto(updateReq);
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable String tagId) {
        tagService.deleteTagBy(tagId);
        return ResponseEntity.noContent().build();
    }
}
