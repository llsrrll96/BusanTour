package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.api.AttractionServiceApiExplorer;
import com.tour.app.api.BusanThemaApiExplorer;
import com.tour.app.domain.AttractionService;
import com.tour.app.domain.RecommendedService;
import com.tour.app.mapper.AttractionServiceMapper;
import com.tour.app.repository.AttractionServiceRepository;
import com.tour.app.repository.ManageRepository;

@Service
public class ManageService // 관리자
{
	@Autowired
	private ManageRepository manageRepository;
	
	@Autowired
	private AttractionServiceMapper mapper;
	
	final BusanThemaApiExplorer btae = new BusanThemaApiExplorer();
	final AttractionServiceApiExplorer asae= new AttractionServiceApiExplorer();
	
	public int requestBusanThema(String pageNo, String numOfRows) {
		List<RecommendedService> busanThemaList= btae.requestAPI(Integer.parseInt(pageNo),Integer.parseInt(numOfRows));
		return manageRepository.saveAll(busanThemaList).size(); // 저장된 갯수
	}

	public List<AttractionService> requestAttraction(String pageNo, String numOfRows) {
		List<AttractionService> attractionList= asae.requestASAPI(Integer.parseInt(pageNo),Integer.parseInt(numOfRows));
//		return mapper.saveAll(attractionList);
		return attractionList;
	}
	
	

	
}
