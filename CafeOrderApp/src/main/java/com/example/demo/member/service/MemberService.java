package com.example.demo.member.service;

import com.example.demo.member.dao.MemberDAO;
import com.example.demo.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDAO memberDAO;

    public void registerMember(MemberDTO member) {
        memberDAO.insertMember(member);
    }

    public MemberDTO login(String email, String password) {
        return memberDAO.findByEmailAndPassword(email, password);
    }
}
