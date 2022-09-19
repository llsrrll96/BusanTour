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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name = "room_boards")
public class RoomBoard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rboardid;
	
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Member members;
	
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="roomid")
	private Room rooms;
	
	private String title;
	private String body;
	private String category;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	private Date regdate; // 입력일자

}
