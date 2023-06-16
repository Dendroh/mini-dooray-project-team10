package com.example.minidoorayproject.exception;

public class NotFoundMemberException extends RuntimeException {
    public NotFoundMemberException(Integer memberId) {
        super("존재하지 않는 멤버입니다. : " + memberId);
    }

    public NotFoundMemberException(String memberEmail) {
        super("존재하지 않는 멤버입니다. : " + memberEmail);
    }
}
