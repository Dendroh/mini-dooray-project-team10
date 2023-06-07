package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.*;
import org.assertj.core.api.AssertionsForInterfaceTypes;
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
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    private Comment comment;

    @BeforeEach
    void setUp(){

        Member writer = new Member();
        writer.setMemberId(21);
        writer.setMemberName("testUser");
        writer.setMemberEmail("testUser@gmail.com");
        entityManager.persist(writer);

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeName("Run");
        statusCode.setCodeId(21);
        entityManager.persist(statusCode);

        Project project = new Project();
        project.setProjectStatus(statusCode);
        project.setProjectTitle("testProject");
        project.setAdmin(writer);
        project.setProjectId(21);
        entityManager.persist(project);

        Task task = new Task();
        task.setTaskId(21);
        task.setTaskName("testTask");
        task.setContent("Test Content");
        task.setWriteTime(LocalDateTime.now());
        task.setWriter(writer);
        task.setProject(project);
        entityManager.persist(task);

        comment = new Comment();
        comment.setCommentId(12);
        comment.setContent("testComment");
        comment.setWriteTime(LocalDateTime.now());
        comment.setWriter(writer);
        comment.setTask(task);
        entityManager.persist(comment);
        entityManager.flush();

    }

    @Test
    void testCreateAndFindById() {


        // Save the comment
        Comment savedComment = commentRepository.saveAndFlush(comment);


        // Retrieve the comment
        Comment retrievedComment = commentRepository.findById(savedComment.getCommentId()).orElse(null);
        assertThat(retrievedComment).isNotNull();
        assertThat(retrievedComment).isEqualTo(savedComment);
    }
    @Test
    public void testFindByContent() {


        // when
        Optional<Comment> found = commentRepository.findById(comment.getCommentId());

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get().getContent()).isEqualTo(comment.getContent());
    }

    @Test
    void testDelete() {

        // Save the comment
        Comment savedComment = commentRepository.save(comment);


        // Delete the comment
        commentRepository.delete(savedComment);
        entityManager.flush();

        // Try to retrieve the comment
        Comment retrievedComment = commentRepository.findById(savedComment.getCommentId()).orElse(null);
        assertThat(retrievedComment).isNull();
    }

    @Test
    void testUpdate() {




        // Save the comment
        Comment savedComment = commentRepository.save(comment);
        entityManager.flush();

        // Update the comment
        savedComment.setContent("Updated Comment");
        commentRepository.save(savedComment);
        entityManager.flush();

        // Retrieve the comment
        Comment retrievedComment = commentRepository.findById(savedComment.getCommentId()).orElse(null);
        assertThat(retrievedComment).isNotNull();
        assertThat(retrievedComment.getContent()).isEqualTo("Updated Comment");
    }

    @Test
    void testFindAll() {



        Member writer = new Member();
        writer.setMemberId(2);
        writer.setMemberName("testUser1");
        writer.setMemberEmail("testUser1@gmail.com");
        entityManager.persist(writer);

        StatusCode statusCode = new StatusCode();
        statusCode.setCodeName("Complete");
        statusCode.setCodeId(2);
        entityManager.persist(statusCode);

        Project project = new Project();
        project.setProjectStatus(statusCode);
        project.setProjectTitle("testProject1");
        project.setAdmin(writer);
        project.setProjectId(2);
        entityManager.persist(project);

        Task task = new Task();
        task.setTaskId(2);
        task.setTaskName("testTask");
        task.setContent("Test Content");
        task.setWriteTime(LocalDateTime.now());
        task.setWriter(writer);
        task.setProject(project);
        entityManager.persist(task);

        Comment comment1 = new Comment();
        comment1.setCommentId(2);
        comment1.setContent("testComment");
        comment1.setWriteTime(LocalDateTime.now());
        comment1.setWriter(writer);
        comment1.setTask(task);
        entityManager.persist(comment1);
        entityManager.flush();

        // Save the comments
        commentRepository.save(comment);
        commentRepository.save(comment1);
        entityManager.flush();

        // Retrieve all comments
        List<Comment> comments = commentRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(comments).hasSize(2);
    }
}