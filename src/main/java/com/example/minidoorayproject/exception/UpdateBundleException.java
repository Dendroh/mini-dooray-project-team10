package com.example.minidoorayproject.exception;

public class UpdateBundleException extends RuntimeException {
    public UpdateBundleException() {
        super("갱신할 번들 아이디의 정보가 너무 많습니다.");
    }
}
