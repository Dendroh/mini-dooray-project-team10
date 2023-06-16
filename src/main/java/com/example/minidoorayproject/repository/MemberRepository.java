package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>, MemberRepositoryCustom {

  Member findByMemberId(Integer memberId);

  Optional<Member> queryByMemberEmail(String email);

  Member findByMemberEmail(String memberEmail);

  MemberDto getByMemberEmail(String memberEmail);

  List<MemberDto> getBy();

}
