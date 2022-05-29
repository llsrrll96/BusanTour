package com.tour.app.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ReviewBoardPK.class)
public class ReviewBoard 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;
	
	@Id
	private int boardId;
	
	private String title;
	
	// fk
	@JoinColumn(name="userid")
	@ManyToOne(fetch=FetchType.LAZY)
	private Member member;
	
	//fk
	@JoinColumn(name="contentsid")
	@ManyToOne(fetch=FetchType.LAZY)
	private TourArea tourArea;

	
	private String contents;
	private String area1; //지역1
	private String divide; // 테마
	@Column(columnDefinition = "integer default 0")
	private int hitcount;
	@Column(columnDefinition = "integer default 0")
	private int replycnt;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자
	
	
	
	
}
