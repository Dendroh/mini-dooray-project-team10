package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MileStoneDto;
import com.example.minidoorayproject.service.MileStoneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;


import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MileStoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MileStoneService mileStoneService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllMileStones() throws Exception {
        String projectId = "1";

        List<MileStoneDto> mileStones = new ArrayList<>();

        MileStoneDto mileStone1 = new MileStoneDto(1, "Milestone 1", LocalDateTime.now(), LocalDateTime.now(), 1);
        mileStones.add(mileStone1);

        when(mileStoneService.selectAllMileStoneBy(projectId)).thenReturn(mileStones);

        mockMvc.perform(get("/dooray/project/milestone/{projectId}", projectId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(mileStones.size())));
    }

    @Test
    public void testCreateMileStone() throws Exception {
        MileStoneDto mileStoneDto = new MileStoneDto(1, "Milestone 1", LocalDateTime.now(), LocalDateTime.now(), 1);


        mockMvc.perform(post("/dooray/project/milestone")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mileStoneDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateMileStone() throws Exception {
        MileStoneDto mileStoneDto = new MileStoneDto(1, "Update MileStone", LocalDateTime.now(), LocalDateTime.now(), 1);


        mockMvc.perform(put("/dooray/project/milestone")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mileStoneDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteMileStone() throws Exception {
        String mileStoneId = "1";

        mockMvc.perform(delete("/dooray/project/milestone/{mileStoneId}", mileStoneId))
                .andExpect(status().isNoContent());
    }
}





