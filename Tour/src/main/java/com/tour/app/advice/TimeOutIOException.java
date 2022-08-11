package com.tour.app.advice;

import lombok.Getter;

@Getter
public class TimeOutIOException extends RuntimeException
{
	private ErrorCode errorCode;
	
	public TimeOutIOException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
