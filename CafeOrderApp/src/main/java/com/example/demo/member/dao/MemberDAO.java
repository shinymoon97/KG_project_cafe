package com.example.demo.member.dao;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAO {
    private final List<MemberDTO> members = new ArrayList<>();

    public void save(MemberDTO member) {
        members.add(member);
    }

    public List<MemberDTO> findAll() {
        return members;
    }
}
