package com.tour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.config.auth.PrincipalDetails;

import com.tour.app.domain.MyBoard;
import com.tour.app.service.MyBoardService;

@RequestMapping("/myBoard/*")
@Controller
public class MyBoardController {	

	@Autowired
	private MyBoardService myBoardService;
	
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
		return "/mypage/insert";
	}
	//게시글 추가
	@PostMapping("insert")
	public String insert(MyBoard myBoard, @AuthenticationPrincipal PrincipalDetails principal) {
		
		myBoardService.insert(myBoard, principal.getMember());
		return "/mypage/list";
	}
	//게시글 전체보기 
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("myBoards", myBoardService.findAll());
		return "/mypage/list";
	}

}
