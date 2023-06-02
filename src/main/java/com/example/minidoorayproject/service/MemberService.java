package com.example.minidoorayproject.service;

import com.example.minidoorayproject.repository.MemberRepository;

public class MemberService {
  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
}
