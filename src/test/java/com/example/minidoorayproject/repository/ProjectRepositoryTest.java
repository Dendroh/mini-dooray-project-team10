package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.domain.ProjectDtoImpl;
import com.example.minidoorayproject.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    private Member admin;

    private StatusCode statusCode;


    @BeforeEach
    void setUp(){
        admin = new Member();
        admin.setMemberName("Manty");
        admin.setMemberEmail("Manty@gmail.com");
        entityManager.persistAndFlush(admin);

        statusCode = new StatusCode();
        statusCode.setCodeName("Run");
        entityManager.persistAndFlush(statusCode);
    }

    @Test
    public void findByProjectIdTest() {
        Project project = new Project();
        project.setProjectTitle("test project");
        project.setProjectStatus(statusCode);
        project.setAdmin(admin);
        entityManager.persistAndFlush(project);

        Project found = projectRepository.findByProjectId(project.getProjectId());
        assertThat(found).isEqualTo(project);
    }

    @Test
    public void findAllByAdmin_MemberIdTest() {
        Project project = new Project();
        project.setProjectTitle("test project");
        project.setProjectStatus(statusCode);
        project.setAdmin(admin);
        entityManager.persistAndFlush(project);

        List<Project> found = projectRepository.findAllByAdmin_MemberId(admin.getMemberId());
        assertThat(found).containsOnly(project);
    }


    @Test
    public void findByProjectTitleTest() {
        Project project = new Project();
        project.setProjectTitle("test project");
        project.setProjectStatus(statusCode);
        project.setAdmin(admin);
        entityManager.persistAndFlush(project);

        Project found = projectRepository.findByProjectTitle(project.getProjectTitle());
        assertThat(found).isEqualTo(project);
    }
    @Test
    public void getByProjectIdTest() {
        admin = entityManager.find(Member.class, admin.getMemberId());

        Project project = new Project();
        project.setProjectTitle("test project");
        project.setProjectStatus(statusCode);
        project.setAdmin(admin);  // set the managed admin entity
        entityManager.persistAndFlush(project);

        ProjectDtoImpl found = projectRepository.getByProjectId(project.getProjectId());
        assertThat(found.getProjectId()).isEqualTo(project.getProjectId());
    }
}
