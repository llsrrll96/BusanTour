package com.tour.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.app.api.BusanThemaApiExplorer;
import com.tour.app.domain.RecommendedService;
import com.tour.app.repository.ManageRepository;

@Service
public class ManageService 
{
	@Autowired
	private ManageRepository manageRepository;
	
	final BusanThemaApiExplorer btae = new BusanThemaApiExplorer();

	public int requestBusanThema(String pageNo, String numOfRows) {
		List<RecommendedService> busanThemaList= btae.requestAPI(Integer.parseInt(pageNo),Integer.parseInt(numOfRows));
		return 	manageRepository.saveAll(busanThemaList).size(); // 저장된 갯수
	}


	
}
