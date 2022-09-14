package com.tour.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.app.domain.AttractionService;
import com.tour.app.mapper.AttractionServiceMapper;

@Repository
public class AttractionServiceRepository 
{
	@Autowired
	private AttractionServiceMapper mapper;
	
	public int saveAll(List<AttractionService> asList) {
		return mapper.saveAll(asList);
	}

}
