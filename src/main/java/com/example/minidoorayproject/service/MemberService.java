package com.example.minidoorayproject.service;

import com.example.minidoorayproject.entity.Member;
import org.springframework.stereotype.Service;



import com.example.minidoorayproject.domain.MemberDto;


import java.util.List;

  @Service
  public interface MemberService {
   MemberDto selectAllMemberBy(String memberId);

    MemberDto  createMember(Member member);

    MemberDto  getMember(int id);

    MemberDto updateMember(int id, Member member);

    void deleteMember(int id);
  }


