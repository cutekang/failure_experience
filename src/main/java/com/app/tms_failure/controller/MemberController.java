package com.app.tms_failure.controller;

import com.app.tms_failure.domain.MemberVO;
import com.app.tms_failure.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

//Spring 에 Controller 임을 보고
@Controller
//method 매핑을 위한 설정
@RequestMapping("/member/*")
//생성자 주입을 통해 final 변수 선언
@RequiredArgsConstructor
@Slf4j
public class MemberController {

//    service final 생성자 주입 
    private final MemberService memberService;

//    로그인 후 id 정보를 담을 session 객체
    private final HttpSession session;

//    회원가입 화면 이동
    @GetMapping("join")
    public void goToJoin(MemberVO memberVO) {;}

//    회원가입 후 login 화면으로 redirect
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {
//        단위 테스트 진행 후, 컨트롤러에 작성
        memberService.join(memberVO);
        return new RedirectView("/member/login");
    }

//    로그인 화면 이동
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

//    로그인 완료 후 myhome 으로 redirect
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        Long id = memberService.login(memberVO);

        log.info("{}", id);

        if (id != null) {
            session.setAttribute("loginId", id);
            return new RedirectView("/member/myhome");
        }

        redirectAttributes.addFlashAttribute("login", false);
        return new RedirectView("/member/login");
    }
    
//    로그인 후 회원정보 조회 화면으로 이동
    @GetMapping("myhome")
    public void goToMyHome(Model model) {
        Long id = (Long) session.getAttribute("loginId");
        model.addAttribute("member", memberService.getMember(id).orElseThrow(() -> {
            throw new RuntimeException("Member Not Found");
        }));
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout() {
        session.invalidate();
        return new RedirectView("/member/login");
    }

//    회원정보 수정화면으로 이동
    @GetMapping("update")
    public void goToUpdate(Model model) {
        Long id = (Long) session.getAttribute("loginId");
        model.addAttribute("member", memberService.getMember(id).orElseThrow(() -> {
            throw new RuntimeException("Member Not Found");
        }));
    }

//    회원정보 수정
    @PostMapping("update")
    public RedirectView update(MemberVO memberVO) {
        memberService.edit(memberVO);
        return new RedirectView("/member/myhome");
    }

//    회원 탈퇴
    @GetMapping("withdraw")
    public RedirectView withdraw(MemberVO memberVO) {
        Long id = (Long) session.getAttribute("loginId");
        memberService.withdraw(id);

        return new RedirectView("/member/login");
    }
}
