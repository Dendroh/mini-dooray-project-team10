package com.example.minidoorayproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.example.minidoorayproject.entity.Member;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testSaveAndFindById() {
        // given
        Member member = new Member();
        member.setMemberId(21);
        member.setMemberName("testUser");
        member.setMemberEmail("testUser@gmail.com");

        Member savedMember = entityManager.persist(member);

        // when
        Optional<Member> found = memberRepository.findById(savedMember.getMemberId());


        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get().getMemberName()).isEqualTo(savedMember.getMemberName());
        assertThat(found.get().getMemberEmail()).isEqualTo(savedMember.getMemberEmail());
    }

    @Test
    public void testDeleteById() {
        // given
        Member member = new Member();
        member.setMemberId(11);
        member.setMemberName("testUser");
        member.setMemberEmail("testUser@gmail.com");

        Member savedMember = entityManager.persist(member);

        // when
        memberRepository.deleteById(savedMember.getMemberId());
        Optional<Member> found = memberRepository.findById(savedMember.getMemberId());

        // then
        assertThat(found).isEmpty();
    }
}

