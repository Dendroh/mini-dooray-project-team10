package com.example.minidoorayproject.exception;

public class NotFoundMileStoneException extends RuntimeException {
    public NotFoundMileStoneException() {
        super("해당 마일스톤이 존재하지 않습니다.");
    }
}
