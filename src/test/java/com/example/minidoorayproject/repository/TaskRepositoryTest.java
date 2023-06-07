package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.Project;
import com.example.minidoorayproject.entity.StatusCode;
import com.example.minidoorayproject.entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    void setup(){
        Member writer = new Member();
        writer.setMemberId(1);
        writer.setMemberName("testUser");
        writer.setMemberEmail("testUser@gmail.com");
        entityManager.persist(writer);


        StatusCode statusCode = new StatusCode();
        statusCode.setCodeId(1);
        statusCode.setCodeName("Run");
        entityManager.persist(statusCode);

        Project project = new Project();
        project.setProjectTitle("Test Project");
        project.setAdmin(writer);
        project.setProjectStatus(statusCode);
        entityManager.persist(project);

        task = new Task();
        task.setTaskName("testTask");
        task.setContent("Test Content");
        task.setWriteTime(LocalDateTime.now());
        task.setWriter(writer);
        task.setProject(project);
    }

    @Test
    public void testSaveAndFindById() {



        Task savedTask = taskRepository.saveAndFlush(task);

        // when
        List<Task> found = taskRepository.findByTaskId(savedTask.getTaskId());

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getTaskName()).isEqualTo(savedTask.getTaskName());
    }

    @Test
    public void testUpdate() {
        // given


        Task savedTask = taskRepository.save(task);

        // when
        String updatedTaskName = "updatedTask";
        savedTask.setTaskName(updatedTaskName);
        taskRepository.save(savedTask);

        // then
        List<Task> found = taskRepository.findByTaskId(savedTask.getTaskId());

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getTaskName()).isEqualTo(savedTask.getTaskName());
    }

    @Test
    public void testDelete() {
        // given


        Task savedTask = taskRepository.save(task);

        // when
        taskRepository.delete(savedTask);

        // then
        List<Task> found = taskRepository.findByTaskId(savedTask.getTaskId());

        // then
        assertThat(found).isNotEmpty();

    }
}
