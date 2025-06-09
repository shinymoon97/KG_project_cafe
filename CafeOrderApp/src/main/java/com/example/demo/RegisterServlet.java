package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class RegisterServlet {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO dto) {
        memberService.registerMember(dto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDTO> login(@RequestBody MemberDTO dto) {
        MemberDTO member = memberService.login(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok(member);
    }
}
