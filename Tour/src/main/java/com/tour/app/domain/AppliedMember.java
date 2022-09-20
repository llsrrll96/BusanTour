package com.tour.app.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name = "applied_members")
public class AppliedMember {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long amemberid;
    
    //fk
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userid")
    private Member member;
    
    //fk
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roomid")
    private Room room;

}
