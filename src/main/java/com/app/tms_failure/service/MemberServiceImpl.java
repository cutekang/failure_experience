package com.app.tms_failure.service;

import com.app.tms_failure.domain.MemberVO;
import com.app.tms_failure.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//서비스 Spring 보고
@Service
//생성자 주입을 통한 DAO 사용
@RequiredArgsConstructor
@Slf4j
//작업 단위 관리용
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

//    회원가입
    @Override
    public void join(MemberVO memberVO) {
        memberDAO.insert(memberVO);
    }

//    로그인
    @Override
    public Long login(MemberVO memberVO) {
        return memberDAO.selectIdByEmailAndPassword(memberVO);
    }

//    회원정보 조회
    @Override
    public Optional<MemberVO> getMember(Long id) {
        return memberDAO.selectById(id);
    }

//    회원정보 수정
    @Override
    public void edit(MemberVO memberVO) {
        memberDAO.update(memberVO);
    }

//    회원 탈퇴
    @Override
    public void withdraw(Long id) {
        memberDAO.delete(id);
    }
}
