package com.tour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.ReviewBoard;
import com.tour.app.dto.Area;
import com.tour.app.service.TourReviewService;

@Controller
@RequestMapping("/tourreview/*")
public class TourReviewController 
{
	@Autowired
	private TourReviewService tourReviewService;
	
	//
	
	@GetMapping("tourreviewList")
	public String list(Model model) 
	{
		model.addAttribute("reviewBoards", tourReviewService.findAll());
		return "/tourreview/tourreviewList"; //jsp
	}
	
	@GetMapping("tourreviewForm")
	public String form(Model model)
	{
		model.addAttribute("area1",Area.values());
		return "tourreview/tourreviewForm";
	}
	
	@PostMapping("register")
	@ResponseBody
	public String formRegister(@RequestBody ReviewBoard reviewBoard , @AuthenticationPrincipal  PrincipalDetails principal)
	{
		System.out.println("formRegister: ");
		System.out.println(reviewBoard.getTitle());
		tourReviewService.registerReview(reviewBoard, principal);
		
		return"";
	}
	
	@GetMapping("tourreviewView")
	public String view(Model model)
	{
		
		return "tourreview/tourreviewView";
	}
	
	
}
