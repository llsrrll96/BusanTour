package com.tour.app.dto;

import java.util.Date;

import com.tour.app.domain.Member;

import lombok.Getter;

@Getter
public class MemberVO 
{
	private long userid;
	private String name;
	private String password;
	private String gender;
	private String email;
	private String intro;
	private String address;
	private String profileUrl;
	private String birthday;
	private String role;
	private String withdraw;
	private Date regdate;
	
	
	public MemberVO(Member member) {
		this.userid = member.getUserid();
		this.name = member.getName();
		this.password = member.getPassword();
		this.gender = member.getGender();
		this.email = member.getEmail();
		this.intro = member.getIntro();
		this.address = member.getAddress();
		this.profileUrl = member.getProfileUrl();
		this.birthday = member.getBirthday();
		this.role = member.getRole();
		this.withdraw = member.getWithdraw();
		this.regdate = member.getRegdate();
	}
}
