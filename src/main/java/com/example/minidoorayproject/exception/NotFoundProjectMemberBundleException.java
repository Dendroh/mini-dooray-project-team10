package com.example.minidoorayproject.exception;

public class NotFoundProjectMemberBundleException extends RuntimeException {
    public NotFoundProjectMemberBundleException() {
        super("해당 프로젝트에 속한 멤버가 존재하지 않습니다.");
    }
}
