package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TakeRoom 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int takeRoomId;
	private String title;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="startDate")
	private Date startDate;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="endDate")
	private Date endDate;
	
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Member member;
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contentsId")
	private TourArea tourarea;
	
	private String openYN; // OPEN/CLOSE여부
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자

	
	
	

}
