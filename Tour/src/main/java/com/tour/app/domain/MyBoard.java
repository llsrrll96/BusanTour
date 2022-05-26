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
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Service
@Entity
public class MyBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	private Date regdate;
	private Long hitcount;
	private Long replycnt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	@PrePersist
	public void prePerist()	{
		this.hitcount = this.hitcount==null? 0 : this.hitcount;
		this.replycnt = this.replycnt==null? 0 : this.replycnt;
	}
	
}
