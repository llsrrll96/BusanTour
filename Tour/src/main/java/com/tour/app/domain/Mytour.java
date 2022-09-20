package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "mytours")
public class Mytour 
{
	@Id 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tourid;
	
	@JoinColumn(name = "userid")
	@ManyToOne(fetch=FetchType.LAZY)
	private  Member member;
	
	@Column(length=100, nullable= false)
	private String title;
	
	@Column(length=500, nullable= false)
	private String body;
	
	private String lat; // 위도
	private String lng; // 경도
	
	private Integer rate; // 평점
	
	@Enumerated(EnumType.STRING)
	private BoardScope scope;
	
	@Column(name = "mainimg_url")
	private String mainImgUrl;
	
	private String place;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
}
