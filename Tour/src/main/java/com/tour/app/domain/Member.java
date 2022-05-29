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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@Entity
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid; //필수, 사용자 ID
	@Column(nullable=false)
	private String name; //필수, 성명
	private String nickName; //필수, 별명
	
	private String password; //필수, 패스워드
	
	private String gender; //필수, 성별
	
	private String email; //필수, 메일
	private String phone; //필수X, 연락처
	
	private String interField; //필수, 관심분야 한줄
	private String address; //필수X, 주소
	private String role; //필수, 권한역할    --> ADMIN_ROLE, USER_ROLE
	private String withdraw; //필수, 탈퇴여부
	
	// 리뷰보드 양방향
	@OneToMany(mappedBy="member")
	@JsonIgnoreProperties("member") // 양방향때 서로 호출되는 것을 방지
	private List<ReviewBoard> reviewBoards  = new ArrayList<>();
	
	//tourarea는 일단 단방향
	
	// 관심 보드
	@OneToMany(mappedBy="member")
	@JsonIgnoreProperties("member") // 양방향때 서로 호출되는 것을 방지
	private List<InterestBoard> interestBoards  = new ArrayList<>();
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP) // 날짜형
	@Column(name="regdate")
	private Date regdate; // 작성일자
}
