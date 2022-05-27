package com.tour.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.TourArea;
import com.tour.app.dto.Area;
import com.tour.app.service.TourAreaService;

@RequestMapping("/tourarea/*")
@Controller
public class TourAreaController {
	@Autowired
	private TourAreaService tourAreaService;

	// tourarea 등록
	@GetMapping("tourAreaInsert")
	public String tourAreaInsert(Model model)
	{
		model.addAttribute("area1", Area.values());
		return "tourarea/tourAreaInsert";
	}
	@PostMapping("tourAreaInsert")
	public String tourAreaInsert(TourArea tourarea, HttpSession session, @AuthenticationPrincipal  PrincipalDetails principal)
	{
		  final String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		
		  tourarea.setMember(principal.getMember());
		  tourAreaService.insertTourArea(tourarea,uploadFolder);
		  
		 return "redirect:/main";
	}

	// tourarea 상세정보
	@GetMapping("tourAreaView/{contents_id}")
	public String tourAreaView(@PathVariable int contents_id, Model model , HttpServletRequest request)
	{
		TourArea tourarea = tourAreaService.findById(contents_id);
		model.addAttribute("tourarea",tourarea );
		
		// 카테고리에 넣을 타이틀 값을 세션에 저장하는 방식 사용
		// 화면에서 사용
		HttpSession session = request.getSession();
		session.setAttribute("tourarea_title", tourarea.getTitle());
		session.setAttribute("tourarea_imagefile", tourarea.getImagefile());
		session.setAttribute("tourarea_contentsId", tourarea.getContentsId());

		
		return "tourarea/tourAreaView";
	}
	
}

