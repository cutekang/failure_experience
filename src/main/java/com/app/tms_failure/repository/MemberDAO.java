package com.app.tms_failure.repository;

import com.app.tms_failure.domain.MemberVO;
import com.app.tms_failure.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//RDB 중심 설계에서 객체지향으로 변화시키기 위한 DAO 보고
@Repository
//생성자 주입을 통하여 Mapper final 변수 사용
@RequiredArgsConstructor
public class MemberDAO {

//    생성자 주입으로 인해 final 변수 선언이 가능하다
    private final MemberMapper memberMapper;

//    회원가입
    public void insert(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

//    로그인
    public Long selectIdByEmailAndPassword(MemberVO memberVO) {
        return memberMapper.selectIdByEmailAndPassword(memberVO);
    }
    
//    회원정보 조회
    public Optional<MemberVO> selectById(Long id) {
        return memberMapper.selectById(id);
    }

//    회원정보 수정
    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

//    회원 탈퇴
    public void delete(Long id) {
        memberMapper.delete(id);
    }
}
