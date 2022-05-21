package com.tour.app.domain;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//테스트주석입니다!!
@Data
@NoArgsConstructor @AllArgsConstructor
public class InterestBoardPK implements Serializable{
	//테이블에 지정된 키값의 대상 필드
	//키 2개를 복합키로 만든다.
	private int member; // 키가 들어있는 클래스 이름
	private int tourarea; // 키가 들어있는 클래스 이름
	
}
