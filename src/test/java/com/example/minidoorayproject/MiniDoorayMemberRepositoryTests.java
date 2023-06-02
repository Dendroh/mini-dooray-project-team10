package com.example.minidoorayproject;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MiniDoorayMemberRepositoryTests {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void saveMemberTest() {
    Member member = new Member();
    member.setMemberId(200);
    member.setMemberName("Abigail");
    member.setMemberEmail("Abi@nhn.com");
    memberRepository.saveAndFlush(member);
  }

  @Test
  void getMemberTest() {
    Member member = memberRepository.findMemberByMemberId(200);
    assertThat(member.getMemberName()).isEqualTo("Abigail");
  }
}
