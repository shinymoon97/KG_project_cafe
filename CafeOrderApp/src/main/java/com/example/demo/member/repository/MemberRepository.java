package com.example.demo.member.repository;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
    
    // 이메일로 회원 찾기 (로그인에 유용)
    MemberDTO findByEmail(String email);
}