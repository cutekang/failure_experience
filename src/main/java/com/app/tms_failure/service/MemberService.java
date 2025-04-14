package com.app.tms_failure.service;

import com.app.tms_failure.domain.MemberVO;

import java.util.Optional;

//인터페이스 구현을 통해 메서드의 사용을 강제화 하기 위하여 인터페이스로 서비스 정의
public interface MemberService {

//    회원가입
    public void join(MemberVO memberVO);

//    로그인
    public Long login(MemberVO memberVO);

//    회원정보 조회
    public Optional<MemberVO> getMember(Long id);

//    회원정봇 수정
    public void edit(MemberVO memberVO);

//    회원 탈퇴
    public void withdraw(Long id);
}
