package com.example.minidoorayproject.exception;

public class NotFoundTaskById extends RuntimeException {
    public NotFoundTaskById(Integer id) {
        super("해당 task가 존재하지 않습니다: " + id);
    }
}
