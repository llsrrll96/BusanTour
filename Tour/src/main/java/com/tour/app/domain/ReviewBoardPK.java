package com.tour.app.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ReviewBoardPK implements Serializable
{
	private int boardId;
	private int num;

}
