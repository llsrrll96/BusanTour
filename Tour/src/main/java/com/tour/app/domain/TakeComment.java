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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TakeComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cnum;

//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="num")
	private TakeRoom takeroom;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Member member;  
	private String nickname; // 댓글 작성자 nickname
	private String content;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regdate; // 작성일자

}
