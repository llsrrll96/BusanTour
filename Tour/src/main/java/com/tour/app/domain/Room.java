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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roomid;
	
	//fk
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Member member;
	
	@Column(nullable=false)
	private String title;
	
	private String bannerimgurl;
	private String introduce;
	private String thema; //산책, 바다. 스포츠
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="regdate")
	private Date regdate; // 생성일자
	
	// 모임방의 멤버 신청자의 관계설정
	@OneToMany(mappedBy="room")
	@JsonIgnoreProperties("room") // 양방향때 서로 호출되는 것을 방지
	private List<AppliedMember> appliedMembers = new ArrayList<>();
	
	// 모임방의 멤버 관계설정
	@OneToMany(mappedBy="room")
	@JsonIgnoreProperties("room") // 양방향때 서로 호출되는 것을 방지
	private List<RoomMember> roomMembers = new ArrayList<>();
	
	// 모임방의 게시물 관계설정
	@OneToMany(mappedBy="room")
	@JsonIgnoreProperties("room") // 양방향때 서로 호출되는 것을 방지
	private List<RoomBoard> roomBoards = new ArrayList<>();
}
