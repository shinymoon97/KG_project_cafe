package com.example.demo.member.dao;

import com.example.demo.member.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMember(MemberDTO member) {
        String sql = "INSERT INTO member (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, member.getName(), member.getEmail(), member.getPassword());
    }

    // 로그인용 이메일/비밀번호 검사 메서드 예시
    public MemberDTO findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM member WHERE email = ? AND password = ?";
        return jdbcTemplate.queryForObject(
            sql,
            new Object[]{email, password},
            (rs, rowNum) -> {
                MemberDTO m = new MemberDTO();
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setPassword(rs.getString("password"));
                return m;
            }
        );
    }
}
