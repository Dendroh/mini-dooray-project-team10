package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.domain.StatusCodeDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProject() throws Exception {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(11);
        memberDto.setMemberName("Manty");
        memberDto.setMemberEmail("Manty@gmail.com");

        StatusCodeDto statusCodeDto = new StatusCodeDto();
        statusCodeDto.setCodeId(11);
        statusCodeDto.setStatusName("Run");

        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(11);
        projectDto.setProjectTitle("Project 11");
        projectDto.setAdminId(memberDto.getMemberId());
        projectDto.setCodeId(statusCodeDto.getCodeId());

        log.info("" + projectDto.getProjectId());
        log.info("" + projectDto.getProjectTitle());
        log.info("" + projectDto.getCodeId());
        log.info("" + projectDto.getAdminId());



        // Mock the service method
        when(projectService.createProjectBy(eq(projectDto))).thenReturn(projectDto);


        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.projectId", is(projectDto.getProjectId())))
                .andExpect(jsonPath("$.projectTitle", is(projectDto.getProjectTitle())));
    }

    @Test
    public void testGetProjectById() throws Exception {
        int projectId = 1;
        mockMvc.perform(get("/projects/" + projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectId", is(projectId)));
    }

    @Test
    public void testGetProjectsByAccount() throws Exception {
        String accountId = "nhnacademy";
        mockMvc.perform(get("/projects/account/" + accountId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateProject() throws Exception {
        int projectId = 1;
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectTitle("Updated Project");

        mockMvc.perform(put("/projects/" + projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectId", is(projectId)))
                .andExpect(jsonPath("$.projectTitle", is(projectDto.getProjectTitle())));
    }

    @Test
    public void testDeleteProject() throws Exception {
        int projectId = 1;
        mockMvc.perform(delete("/projects/" + projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
