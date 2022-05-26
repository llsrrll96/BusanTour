package com.tour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.domain.Member;
import com.tour.app.repository.MemberJpaRepository;
import com.tour.app.service.MemberService;
import com.tour.app.service.TourAreaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController 
{
	@Autowired
	private MemberService memberService;
	@Autowired
	private TourAreaService tourAreaService;
	
	private final MemberJpaRepository memberJpaRepository;
	
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("main")
	public String main(Model model) {
		model.addAttribute("tourareaDTOs", tourAreaService.findTourAreaList());
		return "mainhome";
	}
	
	@GetMapping("login")
	public String login(@RequestParam(value="error", required=false)String error) {
		return "/user/login";
	}
	@PostMapping("login") //시큐리티로 실행
	public String login() {
		return "/user/login";
	}
	@GetMapping("/login/error")
	public String login(Model model)
	{
		model.addAttribute("errorMsg","로그인 이동");
		return "/user/login";
	}
	
	@GetMapping("join")
	public String join() {
		return "/user/join";
	}
	
	// 회원가입
	@PostMapping("register")
	@ResponseBody // return data
	public String register(@RequestBody Member member)
	{
		  if(memberJpaRepository.findByName(member.getName())!=null) {  //username 이 테이블에 있으면 있는 아이디
			  return "fail";
		  }
		
		memberService.register(member);
		
		return "success";
	}
	

}
