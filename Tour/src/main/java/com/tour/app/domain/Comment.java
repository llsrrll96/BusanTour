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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentid;
	
	@JoinColumn(name="userid")
	@ManyToOne(fetch=FetchType.LAZY)
	private Member member;
	
	@JoinColumn(name= "rboardid")
	@ManyToOne(fetch=FetchType.LAZY)
	private RoomBoard roomBoard;
	
	@Column(length = 1000, nullable = false)
	private String body;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
}
