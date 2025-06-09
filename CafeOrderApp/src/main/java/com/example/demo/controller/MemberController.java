package com.example.demo.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/register")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO dto) {
        memberService.registerMember(dto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDTO> login(@RequestBody MemberDTO dto) {
        MemberDTO member = memberService.login(dto.getEmail(), dto.getPassword());
        if (member != null) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
