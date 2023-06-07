package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

  List<Member> findMemberByMemberId(Integer memberId);

}
