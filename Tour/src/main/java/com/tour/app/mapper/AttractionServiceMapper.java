package com.tour.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.AttractionService;

@Mapper
public interface AttractionServiceMapper 
{
	public int saveAll(List<AttractionService> asList);

}
