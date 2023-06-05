package com.example.minidoorayproject.service;

import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member createMember(Member member) {
    return memberRepository.save(member);
  }

  public Member getMember(int id) {
    return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
  }

//  public Optional<Member> getMemberById(int id) {
//    return memberRepository.findById(id);
//  }

  public Member updateMember(int id, Member updatedMember) {
    return memberRepository.findById(id)
            .map(member -> {
              member.setMemberName(updatedMember.getMemberName());
              member.setMemberEmail(updatedMember.getMemberEmail());
              return memberRepository.save(member);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
  }

  public void deleteMember(int id) {
    if (memberRepository.existsById(id)) {
      memberRepository.deleteById(id);
    } else {
      throw new ResourceNotFoundException("Member", "id", id);
    }
  }
}
