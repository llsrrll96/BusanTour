package com.tour.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "mytours")
public class Mytour {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tourid;
	
	//참여방 관계설정
	@OneToMany(mappedBy="mytour")
	private List<Room> rooms = new ArrayList<>();
	
	private String title; //제목
	private String body;  //내용
	private String lat;   //위도
	private String lng;   //경도
	private Long rate;    //평점
	private String range; //범위??
	private String img;   //이미지주소
	private String place; //장소
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	private Date regdate; // 생성일자

}
