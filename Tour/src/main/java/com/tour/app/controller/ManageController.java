package com.tour.app.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.domain.Member;
import com.tour.app.domain.RecommendedService;
import com.tour.app.dto.APIMessage;
import com.tour.app.dto.StatusEnum;
import com.tour.app.service.ManageService;
import com.tour.app.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String manageBoard()	{
		return "/manage/manageBoard";
	}
	
	//api 관리
	@GetMapping("manageAPI")
	public String manageAPI()	{
		return "/manage/manageAPI";
	}
	//

	@PostMapping("busanThema")
	@ResponseBody
	public ResponseEntity<APIMessage> busanThema(@RequestBody HashMap<String, Object> pageData, Model model) throws Exception
	{
		APIMessage apimsg = new APIMessage( );
		log.info((String)pageData.get("pageNo"));
		log.info((String)pageData.get("numOfRows"));
//		try {
			int savecount = manageService.requestBusanThema((String)pageData.get("pageNo"), (String)pageData.get("numOfRows"));
			// 에러를 구분해서 출력
			// 타임아웃 : IOException
			// 더이상 값이 없을 떄 : JsonParseException
			
			HttpHeaders headers= new HttpHeaders();
	        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	        
	        apimsg.setStatus(StatusEnum.OK);
	        apimsg.setMessage("데이터 저장 성공");
	        apimsg.setData((int)savecount);
	        return new ResponseEntity<>(apimsg, headers, HttpStatus.OK);		
	        
//	    }catch(Exception e) {
//	    	apimsg.setStatus(StatusEnum.BAD_REQUEST);
//	        apimsg.setMessage("other");
//	        apimsg.setData((String)e.getMessage());
//			return new ResponseEntity<>(apimsg, null, HttpStatus.OK);		
//		}
	}
	
	
}
