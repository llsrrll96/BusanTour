package com.tour.app.dto;

import lombok.Data;

@Data
public class APIMessage 
{
	private StatusEnum status;
	private String message;
	private Object data;
	
	
	public APIMessage( ) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
}
