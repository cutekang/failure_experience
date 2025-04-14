package com.app.tms_failure.mapper;

import com.app.tms_failure.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

//Mapper 임을 Spring에 보고
@Mapper
public interface MemberMapper {

//    회원 가입
    public void insert(MemberVO memberVO);

//    로그인 (Email / Password 를 입력받아서)
    public Long selectIdByEmailAndPassword(MemberVO memberVO);
    
//    로그인 후 회원 정보 조회
    public Optional<MemberVO> selectById(Long id);

//    회원 정보 수정
    public void update(MemberVO memberVO);

//    회원 탈퇴
    public void delete(Long id);
}
