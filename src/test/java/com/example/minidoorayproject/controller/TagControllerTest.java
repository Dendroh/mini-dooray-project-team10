package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.TagDto;
import com.example.minidoorayproject.service.TagService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TagService tagService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllTagsByProjectId() throws Exception {
//        String projectId = "1";
//
//        // Prepare mock response
//        List<TagDto> tags = new ArrayList<>();
//        tags.add(new TagDto(1, "Tag 1", "Color 1", 1));
//        tags.add(new TagDto(2, "Tag 2", "Color 2", 1));
//        given(tagService.selectAllTagBy(projectId)).willReturn(tags);
//
//        // Perform GET request
//        mockMvc.perform(get("/projects/{projectId}/tags", projectId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].tagId").value(1))
//                .andExpect(jsonPath("$[0].tagName").value("Tag 1"))
//                .andExpect(jsonPath("$[0].tagColor").value("Color 1"))
//                .andExpect(jsonPath("$[0].projectId").value(1))
//                .andExpect(jsonPath("$[1].tagId").value(2))
//                .andExpect(jsonPath("$[1].tagName").value("Tag 2"))
//                .andExpect(jsonPath("$[1].tagColor").value("Color 2"))
//                .andExpect(jsonPath("$[1].projectId").value(1));
    }

    @Test
    public void testCreateTag() throws Exception {
//        TagDto tagDto = new TagDto(1, "Tag 1", "Color 1", 1);
//
//        mockMvc.perform(post("/projects/tags")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(tagDto)))
//                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateTag() throws Exception {
//        TagDto tagDto = new TagDto(1, "Updated Tag", "Updated Color", 1);
//
//        mockMvc.perform(put("/projects/tags")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(tagDto)))
//                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteTag() throws Exception {
//        String tagId = "1";
//
//        mockMvc.perform(delete("/projects/tags/{tagId}", tagId))
//                .andExpect(status().isNoContent());
    }
}
