package com.app.tms_failure.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

//VO 객체 사용시 연결 시키기 위한 어노테이션
@Component
//getter / setter / toString / equals / hashCode / 기본 생성자 / 초기화 생성자 정의
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberAddress;
    private String memberPhone;
}
