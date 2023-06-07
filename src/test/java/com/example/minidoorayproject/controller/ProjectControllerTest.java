//package com.example.minidoorayproject.controller;
//
//import com.example.minidoorayproject.entity.Member;
//import com.example.minidoorayproject.entity.Project;
//import com.example.minidoorayproject.entity.ProjectMemberBundle;
//import com.example.minidoorayproject.entity.StatusCode;
//import com.example.minidoorayproject.service.MemberService;
//import com.example.minidoorayproject.service.ProjectMemberBundleService;
//import com.example.minidoorayproject.service.ProjectService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.hamcrest.core.Is.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class ProjectControllerTest {
////
////    @Autowired
////    MockMvc mockMvc;
////
////    @MockBean
////    private ProjectService projectService;
////
////    @MockBean
////    private ProjectMemberBundleService projectMemberBundleService;
////
////    @MockBean
////    private MemberService memberService;
////
////
////
////
////    @Test
////    @Order(1)
////    void testCreateProject() throws Exception {
////        Project project = new Project();
////        project.setProjectId(11);
////        project.setProjectTitle("Project Name");
////        Member admin = new Member();
////        admin.setMemberId(11);
////        admin.setMemberName("Manty");
////        admin.setMemberEmail("Manty@gmail.com");
////        project.setAdmin(admin);
////
////        when(projectService.createProject(any(Project.class))).thenReturn(project);
////
////        mockMvc.perform(post("/api/project", 11)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(new ObjectMapper().writeValueAsString(project)))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.projectId", is(11)))
////                .andExpect(jsonPath("$.projectTitle", is("Project Name")))
////                .andExpect(jsonPath("$.admin.memberId", is(11)));
////    }
////
////    @Test
////    @Order(2)
////    void testGetProjectMembers() throws Exception {
////        int projectId = 1;
////
////        Member member1 = new Member();
////        member1.setMemberId(1);
////        member1.setMemberName("Manty");
////        member1.setMemberEmail("Manty@gmail.com");
////        Member member2 = new Member();
////        member2.setMemberId(2);
////        member2.setMemberName("Guy");
////        member2.setMemberEmail("Guy@gmail.com");
////
////        StatusCode statusCode = new StatusCode();
////        statusCode.setCodeId(1);
////        statusCode.setStatusName("Run");
////
////        Project project = new Project();
////        project.setProjectId(projectId);
////        project.setProjectTitle("Project Name");
////        project.setProjectStatus(statusCode);
////
////
////
////        ProjectMemberBundle bundle1 = new ProjectMemberBundle();
////        bundle1.setProject(project);
////        bundle1.setMember(member1);
////
////        ProjectMemberBundle bundle2 = new ProjectMemberBundle();
////        bundle2.setProject(project);
////        bundle2.setMember(member2);
////
////        List<ProjectMemberBundle> bundles = Arrays.asList(bundle1, bundle2);
////
////        when(projectMemberBundleService.getProjectMemberBundlesByProjectId(anyInt())).thenReturn(bundles);
////
////        mockMvc.perform(get("/api/project/" + projectId + "/members")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(2)))
////                .andExpect(jsonPath("$[0].member.memberId", is(1)))
////                .andExpect(jsonPath("$[1].member.memberId", is(2)));
////    }
//}
//
//
//
