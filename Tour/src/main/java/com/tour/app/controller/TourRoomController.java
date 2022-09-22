package com.tour.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.Room;
import com.tour.app.service.TourRoomService;

@RequestMapping("/tourRoom/*")
@Controller
public class TourRoomController 
{
	final TourRoomService tourRoomservice;
	
	public TourRoomController(TourRoomService tourRoomservice) {
		super();
		this.tourRoomservice = tourRoomservice;
	}

	@GetMapping("tourRooms")
	public String tourRooms() {
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
