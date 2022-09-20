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
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Builder
@Entity
@Table(name = "members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long userid; //필수, 사용자 ID
	@Column(nullable=false)
	private String name; //필수, 성명
	
	private String password; //필수, 패스워드
	
	private String gender; //필수, 성별
	
	private String email; //필수, 메일
	
	private String intro; //필수, 관심분야 한줄
	private String address; //필수X, 관심 지역
	private String profileUrl;
	private String birthday;
	private String role; //필수, 권한역할    --> ADMIN_ROLE, USER_ROLE
	
	// 테이블 생성시 자동으로 0 , @DynamicInsert -> 값이 없을때 default 값으로 들어간다.
	@Column(columnDefinition = "varchar(1) default '0'")
	private String withdraw; //필수, 탈퇴여부
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 작성일자
	
	// 모임방 관계설정
	@OneToMany(mappedBy="member")
	@JsonIgnoreProperties("member") // 양방향때 서로 호출되는 것을 방지
	private List<Room> rooms = new ArrayList<>();
	
	// 모임방의 게시물 관계설정
	@OneToMany(mappedBy="member")
	@JsonIgnoreProperties("member") // 양방향때 서로 호출되는 것을 방지
	private List<RoomBoard> roomBoards = new ArrayList<>();
	
	// 게시물의 댓글 관계설정
	@OneToMany(mappedBy="member")
	@JsonIgnoreProperties("member") // 양방향때 서로 호출되는 것을 방지
	private List<Comment> comments = new ArrayList<>();
	
}
