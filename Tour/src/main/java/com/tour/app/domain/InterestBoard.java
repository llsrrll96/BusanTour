package com.tour.app.domain;

import java.util.Date;

public class InterestBoard {
	private int userId; //필수, 사용자 ID
	private int contentsId; //필수, 컨텐츠 ID
	private String interName; //필수X, 컨텐츠 명칭
	private String interTitle; //필수X, 컨텐츠 제목
	private Date regdate; //필수X, 등록일자(자동생성)
	
}
