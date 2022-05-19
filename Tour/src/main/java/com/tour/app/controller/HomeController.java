package com.tour.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//홈컨트롤러에 테스트 주석!!
// 이것은 홈이다.
@Controller
public class HomeController 
{
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}

}
