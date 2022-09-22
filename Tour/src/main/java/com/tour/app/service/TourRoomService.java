package com.tour.app.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tour.app.domain.Room;
import com.tour.app.repository.TourRoomJpaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TourRoomService 
{
	final TourRoomJpaRepository tourRoomJpaRepository;
	
	public TourRoomService(TourRoomJpaRepository tourRoomJpaRepository) {
		super();
		this.tourRoomJpaRepository = tourRoomJpaRepository;
	}

	public void createTourRoom(Room room, String uploadFolder) 
	{
		UUID uuid = UUID.randomUUID();
		
		MultipartFile mfImage= room.getBannerMultiFile();
		
		String mfImageName="";
		
		try {

			if(!mfImage.isEmpty())
			{
				mfImageName= uuid.toString()+mfImage.getOriginalFilename(); // random+user file name
				mfImage.transferTo(new File(uploadFolder, mfImageName));
				
				room.setBannerimgurl(mfImageName);
				log.debug("mfImageName: "+mfImageName);
				
			}
		} catch (IllegalStateException | IOException e) {
			log.warn("TourAreaService error: "+e.getMessage());
		}
		tourRoomJpaRepository.save(room);
		
	}

}
