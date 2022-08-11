package com.tour.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecommendedService 
{
	@Id
	String uc_seq;
	String main_title;
	String gugun_nm;
	String cate2_nm;
	String lat; //위도
	String lng; //경도
	String main_place;
	String title;
	String main_img_normal;
	String main_img_thumb;
	@Lob	String itemcntnts;
}
