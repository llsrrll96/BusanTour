package com.tour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.domain.Member;
import com.tour.app.domain.PageHandler;
import com.tour.app.dto.Area;
import com.tour.app.dto.TourAreaDTOInterface;
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
	
	
	
//	@GetMapping("/")
//	public String home() {
//		return "main";
//	}
	// tourarea 카드 리스트
//	@GetMapping("main")
//	public String main(Model model) {
//		model.addAttribute("tourareaDTOs", tourAreaService.findTourAreaList());
//		return "mainhome";
//	}
	// tourarea 페이징 카드 리스트
	@GetMapping(value={"/","main"})
	public String main(Model model,
			@PageableDefault(size=6, sort="contents_id", direction=Sort.Direction.DESC) Pageable pageable,
			@RequestParam(required = false, defaultValue="") String area,
			@RequestParam(required = false, defaultValue="") String divide)
			
	{
		Page<TourAreaDTOInterface> tourareaDTOs = tourAreaService.getList(pageable);
		if(!area.isEmpty() )	tourareaDTOs = tourAreaService.getList(area,divide,pageable);
		model.addAttribute("tourareaDTOs",tourareaDTOs);
		
		PageHandler ph = new PageHandler();
		ph.setPage(tourareaDTOs.getPageable().getPageNumber());// 현재페이지
		ph.setTotalPage(tourareaDTOs.getTotalPages()); // 전체 페이지
		int pageBlock = 5;
		int startBlockPage = ((ph.getPage())/pageBlock)*pageBlock+1;
		int endBlockPage=startBlockPage+pageBlock-1;
		endBlockPage= ph.getTotalPage() < endBlockPage ? ph.getTotalPage() : endBlockPage;
		
		model.addAttribute("startBlockPage",startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
				
		model.addAttribute("area1",Area.values());
		
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
