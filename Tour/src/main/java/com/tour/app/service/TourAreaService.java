package com.tour.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.example.demo4.model.FileBoard;
//import com.example.demo4.repository.FileRepository;
import com.tour.app.domain.TourArea; 
import com.tour.app.repository.TourAreaJpaRepository;


@Service
public class TourAreaService {
	@Autowired
	private TourAreaJpaRepository tourAreaJpaRepository;

	//파일추가
	public void fileInsert(TourArea fboard, String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile f = fboard.getUpload();  //업로드할 파일 
		String uploadFileName = "";
		if(!f.isEmpty()) { //파일이 선택됨
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename();
			File saveFile = new File(uploadFolder,uploadFileName);
			
			try {
				f.transferTo(saveFile); //파일 업로드
				fboard.setImageUrl(uploadFileName); //테이블에 저장될 파일 이름
			
				
				tourAreaJpaRepository.save(fboard);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	//파일 리스트
	public List<TourArea> findAll(){
		return tourAreaJpaRepository.findAll();
	}
	
}



