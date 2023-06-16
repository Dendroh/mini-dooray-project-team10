package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.CommentPostReq;
import com.example.minidoorayproject.domain.CommentResp;
import com.example.minidoorayproject.domain.CommentUpdateReq;
import com.example.minidoorayproject.entity.Comment;
import com.example.minidoorayproject.exception.NotFoundCommentException;
import com.example.minidoorayproject.exception.NotFoundMemberException;
import com.example.minidoorayproject.exception.NotFoundTaskById;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.repository.CommentRepository;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.repository.TaskRepository;
import com.example.minidoorayproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<CommentResp> getCommentsByTaskId(Integer taskId) {
        return commentRepository.findByTask_TaskId(taskId).stream()
                .map(CommentServiceImpl::convertToResp)
                .collect(Collectors.toList());
    }

    @Override
    public CommentResp createCommentsByDto(CommentPostReq postReq) {
        Comment newComment = new Comment();
        newComment.setContent(postReq.getContent());
        newComment.setTask(taskRepository.findById(postReq.getTaskId()).orElseThrow(() -> {
            throw new NotFoundTaskById(postReq.getTaskId());
        }));
        newComment.setWriter(memberRepository.queryByMemberEmail(postReq.getWriterEmail()).orElseThrow(() -> {
            throw new NotFoundMemberException(postReq.getWriterEmail());
        }));
        newComment.setWriteTime(LocalDateTime.now());

        return convertToResp(commentRepository.saveAndFlush(newComment));
    }

    @Override
    @Transactional
    public CommentResp updateCommentsByDto(CommentUpdateReq updateReq) {
        Comment comment = commentRepository.findById(updateReq.getCommentId()).orElseThrow(() -> {
            throw new NotFoundCommentException();
        });

        comment.setContent(updateReq.getContent());

        return convertToResp(comment);
    }

    @Override
    @Transactional
    public void deleteCommentBy(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> {
            throw new NotFoundCommentException();
        });

        commentRepository.deleteById(comment.getCommentId());
    }


    public static CommentResp convertToResp(Comment comment) {
        return new CommentResp(comment.getCommentId(), comment.getContent(), comment.getWriteTime(),
                comment.getTask().getTaskId(), comment.getWriter().getMemberEmail(), comment.getWriter().getMemberName());
    }
}