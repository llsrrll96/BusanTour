package com.tour.app.domain;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor 
public class ReviewBoardPK implements Serializable
{
	@Column
	private Integer num;
	private int boardId;

}
