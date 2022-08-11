package com.tour.app.advice;

import lombok.Getter;

@Getter
public class PageEndOverFlowException extends RuntimeException
{
	private ErrorCode errorCode;
	
	public PageEndOverFlowException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
