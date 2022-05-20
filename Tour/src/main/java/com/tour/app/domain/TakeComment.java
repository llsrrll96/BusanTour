package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@IdClass(TakeCommentPK.class)
public class TakeComment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int takeCommentId;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="takeRoomId")
	private TakeRoom takeroom;
	
	private int userId;  //key값 여부 고민
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 작성일자

}
