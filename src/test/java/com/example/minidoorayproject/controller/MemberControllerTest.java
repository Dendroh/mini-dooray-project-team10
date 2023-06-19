package com.example.minidoorayproject.controller;


import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCreateMember() throws Exception {
        MemberDto memberDto = new MemberDto(1, "John", "john@example.com");

        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetMember() throws Exception {
        int memberId = 1;

        MemberDto memberDto = new MemberDto(1, "John", "john@example.com");

        given(memberService.getMember(memberId)).willReturn(memberDto);

        mockMvc.perform(get("/members/{id}", memberId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(memberId))
                .andExpect(jsonPath("$.memberName").value(memberDto.getMemberName()))
                .andExpect(jsonPath("$.memberEmail").value(memberDto.getMemberEmail()));
    }

    @Test
    public void testGetMemberEmail() throws Exception {
        int memberId = 1;

        MemberDto memberDto = new MemberDto(1, "John", "john@example.com");

        given(memberService.getMember("john@example.com")).willReturn(memberDto);

        mockMvc.perform(get("/members/email/{email}", "john@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(memberId))
                .andExpect(jsonPath("$.memberName").value(memberDto.getMemberName()))
                .andExpect(jsonPath("$.memberEmail").value(memberDto.getMemberEmail()));
    }

    @Test
    public void testUpdateMember() throws Exception {
        int memberId = 1;

        MemberDto updatedMemberDto = new MemberDto(1, "Updated John", "UpdatedJohn@example.com");

        doReturn(updatedMemberDto).when(memberService).updateMember(eq(memberId), ArgumentMatchers.any());


        mockMvc.perform(put("/members/{id}", memberId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedMemberDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberId").value(updatedMemberDto.getMemberId()))
                .andExpect(jsonPath("$.memberName").value(updatedMemberDto.getMemberName()))
                .andExpect(jsonPath("$.memberEmail").value(updatedMemberDto.getMemberEmail()));
    }

    @Test
    public void testDeleteMember() throws Exception {
        int memberId = 1;

        ResultActions resultActions = mockMvc.perform(delete("/members/{id}", memberId))
                .andExpect(status().isNoContent());

        verify(memberService).deleteMember(memberId);

        // Additional assertions if needed
        verify(memberService, times(1)).deleteMember(memberId);
        verifyNoMoreInteractions(memberService);
    }
}