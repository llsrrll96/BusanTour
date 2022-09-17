package com.tour.app.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
public class AttractionService 
{
	@Id
	private String ucSeq;
	private String mainTitle;
	private String gugunName;
	private String lat;
	private String lng;
	private String place;
	private String addr1;
	private String mainImageNormal;
	private String mainImageThumb;
	
	@Enumerated(EnumType.STRING)
	private UploadPart uploadPart;

}
