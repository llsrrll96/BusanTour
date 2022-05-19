package com.tour.app.domain;

import java.util.Date;

public class InterestBoard {
	int userId; //필수, 사용자 ID
	int contentsId; //필수, 컨텐츠 ID
	String interName; //필수X, 컨텐츠 명칭
	String interTitle; //필수X, 컨텐츠 제목
	Date regdate; //필수X, 등록일자(자동생성)
	
}
