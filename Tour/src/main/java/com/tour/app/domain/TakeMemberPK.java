package com.tour.app.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class TakeMemberPK implements Serializable {
	private int userid;

	private int takeRoomId;

}
