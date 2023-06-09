package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dooray/project/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

//    @GetMapping("/{memberId}")
//    public ResponseEntity<MemberDto> getAllMembers(@PathVariable String memberId) {
//        MemberDto memberDto = memberService.selectAllMemberBy(memberId);
//        return ResponseEntity.ok(memberDto);
//    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody Member member) {
        MemberDto createdMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable int id) {
        MemberDto memberDto = memberService.getMember(id);
        return ResponseEntity.ok(memberDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable int id, @RequestBody Member member) {
        MemberDto updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
