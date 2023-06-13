package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.ProjectMemberBundle;
import com.example.minidoorayproject.entity.StatusCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMemberBundleRepository projectMemberBundleRepository;

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Project project;

    @BeforeEach
    public void setUp() {
        StatusCode statusCode = new StatusCode();
        statusCode.setCodeName("In Progress");
        entityManager.persistAndFlush(statusCode);

        Member admin = new Member();
        admin.setMemberName("Admin Name");
        admin.setMemberEmail("admin@example.com");
        entityManager.persistAndFlush(admin);

        project = new Project();
        project.setProjectTitle("Project 100");
        project.setProjectStatus(statusCode);
        project.setAdmin(admin);
    }

    @Test
   void testCreateProject() {
        Project savedProject = projectRepository.saveAndFlush(project);
        assertNotNull(savedProject);
        assertNotNull(savedProject.getProjectId());
        assertEquals("Project 100", savedProject.getProjectTitle());
        assertEquals("In Progress", savedProject.getProjectStatus().getCodeName());
        assertEquals("Admin Name", savedProject.getAdmin().getMemberName());
    }

    @Test
     void testGetProject() {
        entityManager.persist(project);
        Project foundProject = projectRepository.findById(project.getProjectId()).orElse(null);
        assertNotNull(foundProject);
        assertEquals(project.getProjectTitle(), foundProject.getProjectTitle());
    }

    @Test
    void testUpdateProject() {
        Project savedProject = entityManager.persist(project);
        String updatedTitle = "Updated Project Title";
        savedProject.setProjectTitle(updatedTitle);
        projectRepository.save(savedProject);

        Project updatedProject = projectRepository.findById(savedProject.getProjectId()).orElse(null);
        assertNotNull(updatedProject);
        assertEquals(updatedTitle, updatedProject.getProjectTitle());
    }

    @Test
    void testDeleteProject() {
        Project savedProject = entityManager.persist(project);
        projectRepository.deleteById(savedProject.getProjectId());

        Project deletedProject = projectRepository.findById(savedProject.getProjectId()).orElse(null);
        assertNull(deletedProject);

        projectRepository.deleteById(1);

        assertThat(projectMemberBundleRepository.findByProject_ProjectId(1)).isEmpty();
        assertThat(milestoneRepository.findAllByProject_ProjectId(1)).isEmpty();
        assertThat(tagRepository.findAllByProject_ProjectId(1)).isEmpty();
        assertThat(taskRepository.findByProject_ProjectId(1)).isEmpty();

    }
}
