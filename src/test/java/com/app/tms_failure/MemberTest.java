package com.app.tms_failure;

import com.app.tms_failure.domain.MemberVO;
import com.app.tms_failure.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//테스트를 위한 어노테이션
@SpringBootTest
@Slf4j
public class MemberTest {

//    테스트환경에서 생성자 주입을 사용할 수 가 없기 때문에
//    Auto Wired 를 사용하여 Spring 에서 관리하는 객체를 가져오도록 함
    @Autowired
    private MemberService memberService;

//    테스트 메서드에 대한 어노테이션
    @Test
    public void memberJoinTest() {
//        테스트를 위한 객체화 및 값 설정
        MemberVO memberVO = new MemberVO();

//        아이디 set
        memberVO.setId(1L);
//        이메일 set
        memberVO.setMemberEmail("abc@qwe.qwe");
//        비밀번호 set
        memberVO.setMemberPassword("12345");
//        이름 set
        memberVO.setMemberName("고길동");
//        주소 set
        memberVO.setMemberAddress("길동하우스");
//        전화번호 set
        memberVO.setMemberPhone("123412341234");
        memberService.join(memberVO);
    }

    @Test
    public void memberLoginTest(){
//        테스트를 위한 객체화 및 값 설정
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("abc@qwe.qwe");
        memberVO.setMemberPassword("12345");

        log.info("{}", memberService.login(memberVO));
    }

//    회원정보 조회 테스트
    @Test
    public void getMemberTest(){
        Long memberId = 1L;
        memberService.getMember(memberId).map(MemberVO::toString).ifPresent(log::info);
    }

//    업데이트 테스트
    @Test
    public void editMemberTest(){
        MemberVO memberVO = new MemberVO();

        //        아이디 set
        memberVO.setId(1L);
//        이메일 set
        memberVO.setMemberEmail("고길동");
//        비밀번호 set
        memberVO.setMemberPassword("123");
//        이름 set
        memberVO.setMemberName("고길동");
//        주소 set
        memberVO.setMemberAddress("길동하우스");
//        전화번호 set
        memberVO.setMemberPhone("00000000");

        memberService.edit(memberVO);
    }
}
