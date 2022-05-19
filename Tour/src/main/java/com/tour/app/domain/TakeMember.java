package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class TakeMember 
{
	private int userId;
	private int takeMemberId;
	
	private Date takeDate; //참여일자
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자
}
