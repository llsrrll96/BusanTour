package com.tour.app.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode 
{
	TIME_OUT(101,"TIMEOUT","api 서버에서 응닶 없음"),
	PAGE_END_OVERFLOW(102,"PAGE_END_OVERFLOW","더 이상 데이터가 없음"),
	OTHER_ERROR(103,"OTHER_ERROR","그 밖의 에러");
	private int status;
	private String errorCode;
	private String message;
}
