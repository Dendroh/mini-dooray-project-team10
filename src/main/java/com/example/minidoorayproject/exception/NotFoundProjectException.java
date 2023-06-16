package com.example.minidoorayproject.exception;

public class NotFoundProjectException extends RuntimeException {
    public NotFoundProjectException(Integer projectId) {
        super("해당 프로젝트를 찾을 수 없습니다. : " + projectId);
    }

    public NotFoundProjectException(String projectTitle) {
        super("해당 프로젝트를 찾을 수 없습니다. : " + projectTitle);
    }

}
