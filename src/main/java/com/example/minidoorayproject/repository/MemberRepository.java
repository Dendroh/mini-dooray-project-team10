package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

  Member findMemberByMemberId(Integer memberId);

}
