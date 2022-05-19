package com.tour.app.domain;

import java.util.Date;

public class Member {
	private int userId; //필수, 사용자 ID
	private String name; //필수, 성명
	private String nickName; //필수, 별명
	private String password; //필수, 패스워드
	private String gender; //필수, 성별
	private String email; //필수, 메일
	private String phone; //필수X, 연락처
	private String interField; //필수, 관심분야
	private String address; //필수X, 주소
	private String role; //필수, 권한역할
	private String withdraw; //필수, 탈퇴여부
	private Date regdate; //필수, 등록일자(자동)
}
