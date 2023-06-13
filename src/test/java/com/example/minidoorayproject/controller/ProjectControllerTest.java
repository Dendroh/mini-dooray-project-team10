package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.ProjectDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.repository.ProjectRepository;
import com.example.minidoorayproject.service.ProjectService;
import com.example.minidoorayproject.service.impl.ProjectServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    void testCreateProject() throws Exception {

        ProjectDto projectDto = new ProjectDto(11,"Project 11", 1, 10 );


        // Mock the service method
        doReturn(projectDto).when(projectService).createProjectBy(any());

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.projectId").value(projectDto.getProjectId()))
                .andExpect(jsonPath("$.projectTitle").value(projectDto.getProjectTitle()));
    }

    @Test
    void testGetProjectById() throws Exception {
        int projectId = 1;
        ProjectDto projectDto = new ProjectDto(projectId, "Project 1", 1, 10);

        given(projectService.getProjectById(projectId)).willReturn(projectDto);

        mockMvc.perform(get("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectId").value(projectId));
    }

    @Test
    void testGetProjectsByAccount() throws Exception {
        String accountId = "1";
        mockMvc.perform(get("/projects/account/{accountId}", accountId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateProject() throws Exception {
        int projectId = 1;
        ProjectDto projectDto = new ProjectDto(projectId, "Updated Project", 1, 10);


        doReturn(projectDto).when(projectService).updateProjectBy(eq(projectId), any());

        mockMvc.perform(put("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectId").value(projectId))
                .andExpect(jsonPath("$.projectTitle").value(projectDto.getProjectTitle()));
    }

    @Test
    void testDeleteProject() throws Exception {
        int projectId = 1;
        mockMvc.perform(delete("/projects/{id}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
