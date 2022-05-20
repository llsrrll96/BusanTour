package com.tour.app.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReviewBoardPK implements Serializable
{
	private int boardId;
	private int num;

}
