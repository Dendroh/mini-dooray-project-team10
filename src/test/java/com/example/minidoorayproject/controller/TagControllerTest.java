package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.*;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.service.TagService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TagService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testGetTagByProjectId() throws Exception {
        Member admin = new Member();
        admin.setMemberId(1);
        admin.setMemberEmail("test@test.com");
        admin.setMemberName("Test Member");

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeName("Run");

        Project project = new Project();
        project.setProjectId(1);
        project.setProjectTitle("Test Project");
        project.setAdmin(admin);
        project.setProjectStatus(statusCode);


        TagDto tag = new TagDto(1, "Test tag", "blue", 1);

        when(service.selectAllTagBy("1")).thenReturn(Arrays.asList(tag));



        mockMvc.perform(get("/tags/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].tagId", is(1)));
    }

    @Test
    @Order(2)
    public void testPostTagByDto() throws Exception {

        Member admin = new Member();
        admin.setMemberId(1);
        admin.setMemberEmail("test@test.com");
        admin.setMemberName("Test Member");

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeName("Run");

        Project project = new Project();
        project.setProjectId(1);
        project.setProjectTitle("Test Project");
        project.setAdmin(admin);
        project.setProjectStatus(statusCode);

        TagPostReq postReq = new TagPostReq();
        postReq.setTagName("Test tag");
        postReq.setTagColor("blue");
        postReq.setProjectId(1);

        TagDtoResp tag = new TagDtoResp(1, "Test tag", "blue", 1);

        when(service.createTagByDto(any(TagPostReq.class))).thenReturn(tag);

        mockMvc.perform(post("/tags/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postReq)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tagId", is(tag.getTagId())));
    }

    @Test
    @Order(3)
    public void testUpdateTagByDto() throws Exception {
        TagUpdateReq updateReq = new TagUpdateReq();
        updateReq.setTagId(1);
        updateReq.setTagName("Updated tag");
        updateReq.setTagColor("green");

        TagDtoResp tag = new TagDtoResp(1, "Updated tag", "green", 1);

        when(service.updateTagByDto(any(TagUpdateReq.class))).thenReturn(tag);

        mockMvc.perform(put("/tags/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateReq)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tagName", is(tag.getTagName())));
    }

    @Test
    @Order(4)
    public void testDeleteTag() throws Exception {
        Mockito.doNothing().when(service).deleteTagBy("1");

        mockMvc.perform(delete("/tags/1"))
                .andExpect(status().isNoContent());
    }
}
