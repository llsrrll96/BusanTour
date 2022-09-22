package com.tour.app.dto;

import java.util.Date;

import com.tour.app.domain.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO 
{
	private long roomid;
	private MemberVO memberVo;
	private String title;
	private String bannerimgurl;
	private String introduce;
	private String thema;
	private Date regdate;
	
	public RoomDTO(Room entity)
	{
		this.roomid = entity.getRoomid();
		this.memberVo = new MemberVO(entity.getMember());
		this.title = entity.getTitle();
		this.bannerimgurl = entity.getBannerimgurl();
		this.introduce = entity.getIntroduce();
		this.thema = entity.getThema();
		this.regdate = entity.getRegdate();
	}
}
