package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.entity.Member;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MemberRepositoryCustom {
    Member updateMemberByEmail(MemberDto memberDto);
}
