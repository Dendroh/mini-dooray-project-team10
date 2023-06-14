package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.TagDto;
import com.example.minidoorayproject.service.TagInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagInterface tagService;

    @GetMapping("/tags/{projectId}")
    public ResponseEntity<List<TagDto>> getAllTagsByProjectId(@PathVariable String projectId) {
        List<TagDto> tags = tagService.selectAllTagBy(projectId);
        return ResponseEntity.ok(tags);
    }

    @PostMapping("/tags/")
    public ResponseEntity<Void> createTag(@RequestBody TagDto tagDto) {
        tagService.createTagBy(tagDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/tags/")
    public ResponseEntity<Void> updateTag(@RequestBody TagDto tagDto) {
        tagService.updateTagBy(tagDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable String tagId) {
        tagService.deleteTagBy(tagId);
        return ResponseEntity.noContent().build();
    }
}
