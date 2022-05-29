package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@IdClass(TakeMemberPK.class)
public class TakeMember 
{
	@Id
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="num")
	private TakeRoom takeroom;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Member member; //사용자 ID
	private String entrant;  // 참여오픈방 참여자 nickname
	
	private String takeyn; //참여자의 의견참여 여부값
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="regdate")
	private Date regdate; // 등록일자,참가일자
}
