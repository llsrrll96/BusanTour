package com.tour.app.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class TakeMemberPK implements Serializable {
	private int userId;

	private int takeroom; // 외래키 일 경우 클래스명

}
