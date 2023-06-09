package com.example.minidoorayproject.service.impl;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.exception.ResourceNotFoundException;
import com.example.minidoorayproject.repository.MemberRepository;
import com.example.minidoorayproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public MemberDto getMember(int id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));
        return convertToDto(member);
    }

    @Override
    public MemberDto updateMember(int id, Member member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", String.valueOf(id)));
        existingMember.setMemberName(member.getMemberName());
        existingMember.setMemberEmail(member.getMemberEmail());
        Member updatedMember = memberRepository.save(existingMember);
        return convertToDto(updatedMember);
    }

    @Override
    public void deleteMember(int id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member", "id", String.valueOf(id));
        }
        memberRepository.deleteById(id);
    }

    private MemberDto convertToDto(Member member) {
        return new MemberDto(member.getMemberId(), member.getMemberName(), member.getMemberEmail());
    }
}
