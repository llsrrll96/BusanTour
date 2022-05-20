package com.tour.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//05.20.16:15 테스트 주석

@Data
@NoArgsConstructor @AllArgsConstructor
public class InterestBoardPK {
	//테이블에 지정된 키값의 대상 필드
	//키 2개를 복합키로 만든다.
	private int userId;
	private int contentId;
	
}
