package com.tour.app.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.ReviewBoard;
import com.tour.app.dto.Area;
import com.tour.app.dto.TourReviewDTO;
import com.tour.app.dto.TourReviewDTOInterface;
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
//		model.addAttribute("reviewBoards", tourReviewService.findAll());
		List<TourReviewDTOInterface> result=tourReviewService.findReviewBoardList();
		model.addAttribute("reviewBoards", result);
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
		tourReviewService.registerReview(reviewBoard, principal);
		
		return"";
	}
	
	@GetMapping("tourreviewView/{num}")
	public String view(@PathVariable int num ,Model model)
	{
		model.addAttribute("reviewBoard", tourReviewService.findById(num));

		return "tourreview/tourreviewView";
	}
	
	
}
