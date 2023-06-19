package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.*;
import com.example.minidoorayproject.service.MileStoneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MilestoneControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MileStoneService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testGetMilestoneById() throws Exception {
        MileStoneDto milestone = new MileStoneDto(1, "Test milestone", LocalDateTime.now(), LocalDateTime.now(), 1);

        when(service.getMilestoneById(1)).thenReturn(milestone);

        mockMvc.perform(get("/milestones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.milestoneId", is(1)));
    }

    @Test
    @Order(2)
    public void testGetMilestoneByProjectId() throws Exception {
        MilestoneResp milestone = new MilestoneResp(1, "Test milestone", LocalDateTime.now(), LocalDateTime.now(), 1);

        when(service.getMilestoneByProjectId(1)).thenReturn(Arrays.asList(milestone));

        mockMvc.perform(get("/milestones/project/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].milestoneId", is(1)));
    }

    @Test
    @Order(3)
    public void testPostMilestoneByDto() throws Exception {
        MileStonePostReq postReq = new MileStonePostReq();
        postReq.setProjectId(1);
        postReq.setMilestoneName("Test milestone");
        postReq.setStartDatetime(LocalDateTime.now());
        postReq.setEndDatetime(LocalDateTime.now());

        MilestoneResp milestone = new MilestoneResp(1, "Test milestone", LocalDateTime.now(), LocalDateTime.now(), 1);

        when(service.createMilestone(any(MileStonePostReq.class))).thenReturn(milestone);

        mockMvc.perform(post("/milestones/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postReq)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.milestoneId", is(milestone.getMilestoneId())));
    }

    @Test
    @Order(4)
    public void testUpdateMilestoneByDto() throws Exception {
        MilestoneUpdateReq updateReq = new MilestoneUpdateReq();
        updateReq.setMilestoneId(1);
        updateReq.setMilestoneName("Updated milestone");
        updateReq.setStartDatetime(LocalDateTime.now());
        updateReq.setEndDatetime(LocalDateTime.now());

        MilestoneResp milestone = new MilestoneResp(1, "Updated milestone", LocalDateTime.now(), LocalDateTime.now(), 1);

        when(service.updateMilestone(any(MilestoneUpdateReq.class))).thenReturn(milestone);

        mockMvc.perform(put("/milestones/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateReq)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.milestoneName", is(milestone.getMilestoneName())));
    }

    @Test
    @Order(5)
    public void testDeleteMilestone() throws Exception {
        Mockito.doNothing().when(service).deleteMilestone(1);

        mockMvc.perform(delete("/milestones/1"))
                .andExpect(status().isNoContent());
    }
}
