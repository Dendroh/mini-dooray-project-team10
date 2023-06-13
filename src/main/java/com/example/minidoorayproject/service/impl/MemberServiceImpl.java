package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.MemberPostReq;
import com.example.minidoorayproject.domain.MemberUpdateReq;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.exception.NotFoundMemberException;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto selectAllMemberBy(String memberId) {
        Member member = memberRepository.findByMemberId(Integer.parseInt(memberId));
        if (member == null) {
            throw new ResourceNotFoundException("Member", "memberId", memberId);
        }
        return convertToDto(member);
    }

    @Override
    public MemberDto createMember(Member member) {
        Member createdMember = memberRepository.save(member);
        return convertToDto(createdMember);
    }

    @Override
    public MemberDto createMemberByDto(MemberPostReq postReq) {
        MemberDto memberDto = memberRepository.getByMemberEmail(postReq.getMemberEmail());

        if (Objects.isNull(memberDto)) {
            MemberDto memberDtoByPost = new MemberDto(null, postReq.getMemberName(), postReq.getMemberEmail());
            return convertToDto(memberRepository.saveAndFlush(convertToEntity(memberDtoByPost)));
        }

        else
            return null;
    }

    @Override
    public MemberDto getMember(int id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));
        return convertToDto(member);
    }

    @Override
    public MemberDto getMember(String email) {
        Member member = memberRepository.findByMemberEmail(email);

        if(Objects.isNull(member)){
            throw new NotFoundMemberException(email);
        }
        return convertToDto(member);
    }

    @Override
    @Transactional
    public MemberDto updateMember(int id, Member member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));
        existingMember.setMemberName(member.getMemberName());
        existingMember.setMemberEmail(member.getMemberEmail());
        Member updatedMember = memberRepository.save(existingMember);
        return convertToDto(updatedMember);
    }

    @Override
    @Transactional
    public MemberDto updateMemberByDto(MemberUpdateReq updateReq) {
        Member member = memberRepository.findByMemberEmail(updateReq.getEmail());

        if (Objects.isNull(member))
            throw new NotFoundMemberException(updateReq.getEmail());

        MemberDto memberDto = convertToDto(member);
        memberDto.setMemberEmail(updateReq.getNewEmail());
        memberDto.setMemberName(updateReq.getNewName());

        memberRepository.updateMemberByDto(memberDto);

        return memberDto;
    }

    @Override
    @Transactional
    public void deleteMember(int id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member", "id", String.valueOf(id));
        }
        memberRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteMember(String email) {
        Member member = memberRepository.findByMemberEmail(email);

        if (Objects.isNull(member))
            throw new NotFoundMemberException(email);

        memberRepository.deleteById(member.getMemberId());
    }

    public static MemberDto convertToDto(Member member) {
        return new MemberDto(member.getMemberId(), member.getMemberName(), member.getMemberEmail());
    }

    public static Member convertToEntity(MemberDto memberDto) {
        Member member = new Member();
        member.setMemberEmail(memberDto.getMemberEmail());
        member.setMemberName(memberDto.getMemberName());

        return member;
    }
}
