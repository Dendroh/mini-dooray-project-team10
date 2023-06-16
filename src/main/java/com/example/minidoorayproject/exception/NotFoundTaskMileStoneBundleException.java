package com.example.minidoorayproject.exception;

public class NotFoundTaskMileStoneBundleException extends RuntimeException {
    public NotFoundTaskMileStoneBundleException() {
        super("해당 task 와 milestone 의 관계가 존재하지 않습니다.");
    }
}
