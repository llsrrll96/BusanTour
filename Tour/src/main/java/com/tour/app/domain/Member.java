package com.tour.app.domain;

import java.util.Date;

public class Member {
	int userId; //필수, 사용자 ID
	String name; //필수, 성명
	String nickName; //필수, 별명
	String password; //필수, 패스워드
	String gender; //필수, 성별
	String email; //필수, 메일
	String phone; //필수X, 연락처
	String interField; //필수, 관심분야
	String address; //필수X, 주소
	String role; //필수, 권한역할
	String withdraw; //필수, 탈퇴여부
	Date regdate; //필수, 등록일자(자동)
}
