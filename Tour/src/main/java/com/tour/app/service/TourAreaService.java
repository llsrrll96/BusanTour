package com.tour.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tour.app.config.auth.PrincipalDetails;
//import com.example.demo4.model.FileBoard;
//import com.example.demo4.repository.FileRepository;
import com.tour.app.domain.TourArea;
import com.tour.app.dto.TourAreaDTOInterface;
import com.tour.app.dto.TourReviewDTOInterface;
import com.tour.app.repository.TourAreaJpaRepository;


@Service
public class TourAreaService {
	@Autowired
	private TourAreaJpaRepository tourAreaJpaRepository;


	public List<TourArea> findAll(){
		return tourAreaJpaRepository.findAll();
	}
	
	
	// 사용자가 tourarea 등록하는 메소드
	public void insertTourArea(TourArea tourarea, String uploadFolder) 
	{
		System.out.println("service insertTourArea");
				
		UUID uuid = UUID.randomUUID(); //파일 이름 겹치지 않게

		MultipartFile mfImage = tourarea.getImageUrl();
		MultipartFile mfThumImage = tourarea.getThumimage_url();
		
		String mfImageName="";
		String mfThumImageName="";
		
		try 
		{
			if(!mfImage.isEmpty())
			{
				mfImageName = uuid.toString()+mfImage.getOriginalFilename();
				
				mfImage.transferTo(new File(uploadFolder, mfImageName));
				tourarea.setImagefile(mfImageName);
				
				System.out.println(mfImageName);
			}
			if(!mfThumImage.isEmpty())
			{
				mfThumImageName = uuid.toString()+mfThumImage.getOriginalFilename();
				
				mfThumImage.transferTo(new File(uploadFolder, mfThumImageName));
				tourarea.setThumimagefile(mfThumImageName);
				System.out.println(mfThumImageName);
			}
			tourAreaJpaRepository.save(tourarea);
		} catch (IllegalStateException | IOException e) {
			System.out.println("TourAreaService error: "+e.getMessage());
		}
		
	}
	
	@Transactional
	public List<TourAreaDTOInterface> findTourAreaList() {
		return 	tourAreaJpaRepository.findTourAreaList();
	}
	
	//페이징 적용
	public Page<TourAreaDTOInterface> getList(Pageable pageable){
		return tourAreaJpaRepository.findTourAreaList(pageable);
	}
	
	public Page<TourAreaDTOInterface> getList(String area, Pageable pageable) {
		return tourAreaJpaRepository.findByAreaContaining(area, pageable);
	}
	
	public Page<TourAreaDTOInterface> getList(String area, String divide, Pageable pageable) {
		return tourAreaJpaRepository.findByAreaDivideContaining(area,divide, pageable);
	}
	
	// 게시물 아이디로 상세 
	public TourArea findById(int contents_id) {
		return tourAreaJpaRepository.findByContentsId(Integer.valueOf(contents_id));
	}










	
}



