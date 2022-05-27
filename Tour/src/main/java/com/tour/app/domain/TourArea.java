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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

// 여행 관광지
//touristarea는 콘텐츠ID   콘텐츠명   구군   테마   장소   제목     이미지URL   썸네일이미지URL 상세정보
@Getter @Setter
@Entity
public class TourArea 
{		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contents_id")
	private int contentsId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	@Getter @Setter
	private Member member;
	
	private String contentsName;
	private String area;
	private String divide; // 테마
	private String course;
	private String title;
	@Transient 
	private MultipartFile imageUrl; //05.23 추가. 이미지 업로드.
	private String imagefile;
	@Transient
	private MultipartFile thumimage_url; 
	private String thumimagefile;
	@Column(length = 1000)
	private String content;
	private String location; //장소
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 등록일자 

}
