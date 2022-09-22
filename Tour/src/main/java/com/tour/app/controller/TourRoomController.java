package com.tour.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.Room;
import com.tour.app.dto.RoomDTO;
import com.tour.app.service.TourRoomService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/tourRoom/*")
@Controller
public class TourRoomController 
{
	final private TourRoomService tourRoomservice;
	
	public TourRoomController(TourRoomService tourRoomservice) {
		this.tourRoomservice = tourRoomservice;
	}

	@GetMapping("tourRooms")
	public String tourRooms(Model model) {
		// 우선 모임 목록 불러오기
		List<RoomDTO> roomDtos= tourRoomservice.findRoomDTOs();
		model.addAttribute("roomDtos",roomDtos);
		return "/tourRoom/tourRooms";
	}
	
	@GetMapping("roomCreation")
	public String roomCreation() {
		return "/tourRoom/roomCreation";
	}
	
	@PostMapping("createRoom")
	public String createRoom(Room room, HttpSession session, @AuthenticationPrincipal PrincipalDetails principal)
	{
		final String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		
		room.setMember(principal.getMember());
		tourRoomservice.createTourRoom(room,uploadFolder);
		
		return "redirect:/tourRoom/tourRooms";
	}
}
