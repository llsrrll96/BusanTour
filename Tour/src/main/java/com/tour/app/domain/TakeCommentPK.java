package com.tour.app.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class TakeCommentPK implements Serializable{
	
	private int takeCommentId;

	private int takeroom; // takeroom 클래스명

}
