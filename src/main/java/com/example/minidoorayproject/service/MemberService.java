package com.example.minidoorayproject.service;

import com.example.minidoorayproject.domain.MemberPostReq;
import com.example.minidoorayproject.domain.MemberUpdateReq;
import com.example.minidoorayproject.entity.Member;
import org.springframework.stereotype.Service;



import com.example.minidoorayproject.domain.MemberDto;


import java.util.List;

  @Service
  public interface MemberService {
   MemberDto selectAllMemberBy(String memberId);

   List<MemberDto> getAllMember();

    MemberDto  createMember(Member member);

    MemberDto createMemberByDto(MemberPostReq postReq);

    MemberDto  getMember(int id);

    MemberDto getMember(String email);

    MemberDto updateMember(int id, Member member);

    MemberDto updateMemberByDto(MemberUpdateReq updateReq);

    void deleteMember(int id);

    void deleteMember(String email);
  }


