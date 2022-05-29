package com.tour.app.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Getter;


public interface MemberDTO 
{
	String getName(); //필수, 성명
	String getNick_name(); //필수, 별명
	String getGender(); //필수, 성별
	String getEmail(); //필수, 메일
	String getRole(); //필수, 권한역할    --> ADMIN_ROLE, USER_ROLE
	String getWithdraw(); //필수, 탈퇴여부
	Date getRegdate(); // 작성일자

}
