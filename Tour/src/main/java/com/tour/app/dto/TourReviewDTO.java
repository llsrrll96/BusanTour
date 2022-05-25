package com.tour.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourReviewDTO 
{
	private int num;
	private String title;
	private String nick_name;
	private Date regdate;
	private int hitcount;
}
