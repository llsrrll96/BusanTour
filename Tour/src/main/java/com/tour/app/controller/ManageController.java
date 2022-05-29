package com.tour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.domain.Member;
import com.tour.app.service.ManageService;
import com.tour.app.service.MemberService;

@RequestMapping("/manage/*")
@Controller
public class ManageController 
{
	@Autowired
	private ManageService manageService;
	@Autowired
	private MemberService memberService; // 멤버 관리
	
	// 관리 홈
	@GetMapping("manageHome")
	public String manageHome(Model model)
	{
		// 멤버수
		model.addAttribute("memberCount", memberService.getMemberCount());
		
		return "manage/manageHome";
	}
	
	// 멤버 관리
	@GetMapping("manageMember")
	public String manageMember(Model model)
	{
		model.addAttribute("memberList", memberService.getMemberDTOList());
		model.addAttribute("count",memberService.getMemberCount());
		return "/manage/manageMember";
	}
	// 멤버 관리 - 권한 부여
	@PutMapping("updateMemberRole")
	@ResponseBody
	public String updateMemberRole(@RequestBody Member member)
	{
		memberService.updateMemberRole(member.getName(), member.getRole());
		return "success";	
	}
	
	// 탈퇴 처리
	@PutMapping("updateMemberWithdraw/{name}")
	@ResponseBody
	public String updateMemberWithdraw(@PathVariable String name)
	{
		memberService.updateMemberWithdraw(name);
		return "success";	
	}
	
	//전체 글 관리
	@GetMapping("manageBoard")
	public String manageBoard()
	{
		return "/manage/manageBoard";
	}
}
