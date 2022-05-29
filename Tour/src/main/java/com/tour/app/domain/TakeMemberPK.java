package com.tour.app.domain;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data 
public class TakeMemberPK implements Serializable {
	private Long takeroom; // 외래키 일 경우 클래스명
	private int member;

	

}
