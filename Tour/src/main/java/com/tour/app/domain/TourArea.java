package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

// 여행 관광지
//touristarea는 콘텐츠ID   콘텐츠명   구군   테마   장소   제목     이미지URL   썸네일이미지URL 상세정보
public class TourArea 
{
	private int contentsId;
	private String contentsName;
	private String area;
	private String divide; // 테마
	private String location;
	private String title;
	private String imageUrl;
	private String image2Url;
	private String detailIntro;
	private int userId;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자 

}
