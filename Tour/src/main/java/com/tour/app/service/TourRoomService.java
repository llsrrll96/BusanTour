package com.tour.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tour.app.domain.Room;
import com.tour.app.dto.RoomDTO;
import com.tour.app.repository.TourRoomJpaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TourRoomService 
{
	final private TourRoomJpaRepository tourRoomJpaRepository;
	
	public TourRoomService(TourRoomJpaRepository tourRoomJpaRepository) {
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
	
	public List<RoomDTO> findRoomDTOs()
	{
		List<Room> rooms= tourRoomJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "roomid"));
		return rooms.stream().map(room -> mapToDto(room)).collect(Collectors.toList());
	}
	
	
	private RoomDTO mapToDto(Room Room) {
		RoomDTO roomDto = new RoomDTO(Room);
		return roomDto;
	}

}
