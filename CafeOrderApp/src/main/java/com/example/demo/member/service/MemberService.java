package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDTO saveMember(MemberDTO member) {
        return memberRepository.save(member);
    }

    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll();
    }

    public MemberDTO findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}