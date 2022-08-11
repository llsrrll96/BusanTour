package com.tour.app.advice;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonParseException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	// 타임아웃
	@ExceptionHandler(TimeOutIOException.class)
	public ResponseEntity<ErrorResponse> handleTimeOutIOException()
	{
		log.info("handleTimeOutIOException");
		ErrorResponse response = new ErrorResponse(ErrorCode.TIME_OUT);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	// 범위 초과(데이터없음)
	@ExceptionHandler(PageEndOverFlowException.class)
	public ResponseEntity<ErrorResponse> handlerPageEndOverFlowException()
	{
		log.info("handlerPageEndOverFlowException");
		ErrorResponse response = new ErrorResponse(ErrorCode.PAGE_END_OVERFLOW);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
