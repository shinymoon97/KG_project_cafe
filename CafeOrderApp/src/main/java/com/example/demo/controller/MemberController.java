package com.example.demo.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public MemberDTO registerMember(@RequestBody MemberDTO member) {
        return memberService.saveMember(member);
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/email")
    public MemberDTO getMemberByEmail(@RequestParam String email) {
        return memberService.findByEmail(email);
    }
}
