package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class ReviewBoard 
{
	private int boardId;
	private int num;
	
	private String title;
	
	// fk
	private int userId;
	private String contents;
	//fk
	private int contentsId;
	private String area1; //지역1
	private String divide; // 테마
	private int hitcount;
	private int replycnt;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자
	
	
}