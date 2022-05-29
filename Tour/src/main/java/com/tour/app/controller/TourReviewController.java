package com.tour.app.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//여행 리뷰 리스트
	@GetMapping("tourreviewList")
	public String list(Model model , HttpServletRequest request) 
	{
//		model.addAttribute("reviewBoards", tourReviewService.findAll());
		int contentsid = (int)request.getSession().getAttribute("tourarea_contentsId");
		
		List<TourReviewDTOInterface> result=tourReviewService.findReviewBoardList(contentsid);
		model.addAttribute("reviewBoards", result);
		return "/tourreview/tourreviewList"; //jsp
	}
	
	// 여행 리뷰 글쓰기 폼 화면
	@GetMapping("tourreviewForm")
	public String form(Model model)
	{
		model.addAttribute("area1",Area.values());
		return "tourreview/tourreviewForm";
	}
	
	// 여행 리뷰 등록하기
	@PostMapping("register")
	@ResponseBody
	public String formRegister(@RequestBody ReviewBoard reviewBoard , 
													@AuthenticationPrincipal  PrincipalDetails principal,
													HttpServletRequest request)
	{
		tourReviewService.registerReview(reviewBoard, principal, 
				(int)request.getSession().getAttribute("tourarea_contentsId"));
		
		return"success";
	}
	
	// 여행 리뷰 글 상세보기 
	@GetMapping("tourreviewView/{num}")
	public String view(@PathVariable int num ,Model model, @AuthenticationPrincipal  PrincipalDetails principal)
	{
		model.addAttribute("reviewBoard", tourReviewService.findById(num));
		try {
			model.addAttribute("sessionUserid", principal.getMember().getUserid());

		}catch(NullPointerException e) {
			model.addAttribute("sessionUserid", "");
		}
		return "tourreview/tourreviewView";
	}
	
	// 여행 리뷰 수정 폼
	@GetMapping("tourreviewUpdateForm/{boardId}/{num}")
	public String updateForm(@PathVariable int boardId, @PathVariable int num, Model model)
	{
		model.addAttribute("reviewBoard", tourReviewService.findById(num));
		model.addAttribute("area1",Area.values());

		return "tourreview/tourreviewUpdateForm";
	}
	
	// 여행 리뷰 수정 put
	@PutMapping("update")
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody ReviewBoard reviewBoard , 
			@AuthenticationPrincipal  PrincipalDetails principal )
	{
		// 수정하기
		tourReviewService.updateTourReview(reviewBoard);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	// 여행 리뷰 삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable int num)
	{
		tourReviewService.deleteTourReview(num);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
}
