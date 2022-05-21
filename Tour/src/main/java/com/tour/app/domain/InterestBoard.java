//테스트 주석추가 2!!
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

@Getter  @Setter
@Entity
@IdClass(InterestBoardPK.class)
public class InterestBoard {
	@Id @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private Member member; //필수, 사용자 ID
	
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contentsId")	
	private TourArea tourarea;
	
	
	private String interTitle; //필수X, 컨텐츠 제목
	private String interName; //필수X, 컨텐츠 명칭
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	private Date regdate; //필수X, 등록일자(자동생성)	
}