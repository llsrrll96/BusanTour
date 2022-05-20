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

import lombok.Getter;
import lombok.Setter;

// 여행 관광지
//touristarea는 콘텐츠ID   콘텐츠명   구군   테마   장소   제목     이미지URL   썸네일이미지URL 상세정보
@Getter @Setter
@Entity
public class TourArea 
{		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contentsId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	@Getter @Setter
	private Member member;
	
	private String contentsName;
	private String area;
	private String divide; // 테마
	private String location;
	private String title;
	private String imageUrl;
	private String image2Url;
	private String detailIntro;
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자 

}
