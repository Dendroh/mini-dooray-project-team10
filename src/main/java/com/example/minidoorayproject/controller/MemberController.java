package com.example.minidoorayproject.controller;

import com.example.minidoorayproject.domain.MemberDto;
import com.example.minidoorayproject.domain.MemberPostReq;
import com.example.minidoorayproject.domain.MemberUpdateReq;
import com.example.minidoorayproject.entity.Member;
import com.example.minidoorayproject.exception.ValidationFailedException;
import com.example.minidoorayproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody Member member) {
        MemberDto createdMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @PostMapping("/")
    public MemberDto createMemberByDto(@Valid @RequestBody MemberPostReq postReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return memberService.createMemberByDto(postReq);
    }

    @GetMapping("")
    public List<MemberDto> getAllMember() {
        return memberService.getAllMember();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Integer id) {
        MemberDto memberDto = memberService.getMember(id);
        return ResponseEntity.ok(memberDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<MemberDto> getMember(@PathVariable String email) {
        MemberDto memberDto = memberService.getMember(email);
        return ResponseEntity.ok(memberDto);
    }

    @PutMapping("/")
    public MemberDto updateMemberByDto(@Valid @RequestBody MemberUpdateReq updateReq, BindingResult result) {
        if (result.hasErrors())
            throw new ValidationFailedException(result);

        return memberService.updateMemberByDto(updateReq);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable Integer id, @RequestBody Member member) {
        MemberDto updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/email/{email}")
    public void deleteMemberByEmail(@PathVariable("email") String email) {
        memberService.deleteMember(email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
