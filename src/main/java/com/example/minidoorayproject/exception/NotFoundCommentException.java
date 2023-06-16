package com.example.minidoorayproject.exception;

public class NotFoundCommentException extends RuntimeException {
    public NotFoundCommentException() {
        super("해당 댓글을 찾을 수 없습니다.");
    }
}
