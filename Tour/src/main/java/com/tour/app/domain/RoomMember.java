package com.tour.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tour.app.dto.RoleEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor 
@Table(name = "room_members")
public class RoomMember {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)	
  private Long memberid;
  
  //fk
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="userid")
  private Member member;
//  private int userid;
  
  //fk
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="roomid")
  private Room room;
//  private int roomid;
  
  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private RoleEnum role;
// private String role; //enum
	
}
