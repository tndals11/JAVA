package org.example.chapter15.b_signup;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
// 실제 회원가입 프로세스의 사용자 데이터
public class User {
    private long id; // 사용자 데이터의 구분값 - 데이터 저장소에서 일괄 부여
    private String username; // 사용자 로그인 아이디
    private String password;
    private String name;
    private String email;
    private String phone;
    private String nickname;
    private Date sighUpdate; // 회원가입 날짜 저장
}
