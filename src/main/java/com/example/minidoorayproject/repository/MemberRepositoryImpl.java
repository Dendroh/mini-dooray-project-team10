package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.entity.QMember;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member updateMemberByDto(MemberDto memberDto) {
        QMember member = QMember.member;

        update(member)
                .set(member.memberEmail, memberDto.getMemberEmail())
                .set(member.memberName, memberDto.getMemberName())
                .where(member.memberId.eq(memberDto.getMemberId()))
                .execute();

        return from(member)
                .where(member.memberId.eq(memberDto.getMemberId()))
                .fetchOne();
    }
}
