package com.tour.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tourRoom/*")
@Controller
public class TourRoomController 
{
	
	@GetMapping("tourRooms")
	public String tourRooms() {
		return "/tourRoom/tourRooms";
	}
	
	@GetMapping("roomCreation")
	public String roomCreation() {
		return "/tourRoom/roomCreation";
	}
}
