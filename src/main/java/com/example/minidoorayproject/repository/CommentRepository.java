package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByTask_TaskId(Integer taskId);

    Comment findByCommentId(Integer commentId);
}