package com.example.minidoorayproject.exception;

public class NotFoundStatusCodeException extends RuntimeException {
    public NotFoundStatusCodeException(String statusCodeName) {
        super("해당 상태가 존재하지 않습니다, 상태 이름: " + statusCodeName);
    }
}
