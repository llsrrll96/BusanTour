package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

public class TakeRoom 
{
	private int takeRoomId;
	private String title;
	private Date startDate;
	private Date endDate;
	
	//fk
	private int userId;
	//fk
	private int contentsId;
	
	private String openYN; // OPEN/CLOSE여부
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자

	
	
	

}
