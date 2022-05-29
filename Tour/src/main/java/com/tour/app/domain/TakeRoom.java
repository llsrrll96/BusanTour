package com.tour.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
public class TakeRoom 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	
	@Column(nullable=false)
	private String title;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="startDate")
	private Date startDate;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="endDate")
	private Date endDate;
	
	//fk
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid")
	private Member member;
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contentsId")
	private TourArea tourarea;
//	private int contentsid;
	
	@Column(columnDefinition = "Long default 0")
	private Long membercnt;
	private String openyn; // OPEN/CLOSE여부
	private String nickname;  // 참여오픈방 개설자
	private String guider;  // 참여오픈방 개설자이름
	private String content;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="regdate")
	private Date regdate; // 등록일자
	
//	@JsonManagedReference
//	@OneToMany(mappedBy ="takeroom", fetch=FetchType.EAGER) //한개의 객체에서는 두개 EAGER는 사용불가
//	@JsonIgnoreProperties("takeroom")
//	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy ="takeroom", fetch=FetchType.LAZY)
	private List<TakeMember> takemembers;
	
//	@Fetch(FetchMode.SELECT)
//	@JsonManagedReference
//	@OneToMany(mappedBy ="takeroom", fetch=FetchType.EAGER) //한개의 객체에서는 두개 EAGER는 사용불가
	@OneToMany(mappedBy ="takeroom", fetch=FetchType.LAZY)
	@JsonIgnoreProperties("takeroom")
	private List<TakeComment> takecomments;
	
	@PrePersist
	public void prePerist() {
	  this.membercnt = this.membercnt==null?0:this.membercnt;
	}
	
}
