package com.tour.app.controller;


import java.util.List;

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
import com.tour.app.domain.TakeRoom;
import com.tour.app.repository.TakeRoomRepository;
import com.tour.app.service.TakeRoomService;

@RequestMapping("/takeroom/*")
@Controller
public class TakeRoomController {
	@Autowired
	private TakeRoomService takeroomService;
	@Autowired
	private TakeRoomRepository takeroomRepository;
 
//	@GetMapping("takeroomList")
//	public String list() 
//	{	
//		return "/takeroom/takeroomList"; //jsp
//	}
	
	//함께해요! 여행참여방폼이동
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public String insert() {
			return "/takeroom/takeroomJoin";
	}
	//함께해요! 여행참여방 만들기
    @PostMapping("insert")
	@ResponseBody
//    public String insert(TakeRoom takeroom,
	public String insert(@RequestBody TakeRoom takeroom,
			@AuthenticationPrincipal PrincipalDetails principal ) {
//    	 logger.info("insert post.....");
//    	 System.out.println("insert 디버깅:"+ takeroom.getTitle());
//    	 System.out.println(takeroom.getClass());
	     if(takeroomRepository.findByTitle(takeroom.getTitle())!= null) {
		       return "fail";
	     }
	     takeroomService.insert(takeroom,principal.getMember());
			
		 return "redirect:/takeroom/takeroomList";
	}
    //추천여행 참여하기 오픈방 전체보기(페이징, 검색)
  	@GetMapping("list")
//  	public String list(Model model) {
  	public String list(Model model,
  		 @PageableDefault(size=5, sort="num",
  		    	  direction = Direction.DESC) Pageable pageable,
  		 @RequestParam(required=false, defaultValue="") String field,
  		 @RequestParam(required=false, defaultValue="") String word) {

  		 Page<TakeRoom> lists = takeroomService.findAll(field, word, pageable);

  		 Long count =takeroomService.count(field, word);
  		 model.addAttribute("takerooms",lists);	
  		 model.addAttribute("count",count);
  		return "/takeroom/takeroomList";  //jsp
  	 }	
  	//참여하기 오픈방 상세화면에서 세부조회
  	@GetMapping("view/{num}")
  	public String view(@PathVariable Long num, Model model) {
  		 model.addAttribute("takeroom", takeroomService.findById(num));
  		
//  		 List<TakeRoom> lists = (List<TakeRoom>) takeroomService.findById(num);
//  		 model.addAttribute("takerooms", lists);
		 
// 		return "/takeroom/entryView";
  		return "/takeroom/takeroomView";
  	}
  	//참여하고 오픈방 삭제하기(마감된 참여오픈방은 삭제 안됨)
  	@DeleteMapping("delete/{num}")
  	@ResponseBody
  	public String delete(@PathVariable Long num) {
  		takeroomService.delete(num);
  		return "success";
  	}
  	//참여하기 오픈방 상세화면에서 마감일자조정 및 오픈/마감 수정폼
  	@GetMapping("update/{num}")
  	public String update(@PathVariable Long num, Model model) {
  		model.addAttribute("takeroom", takeroomService.findById(num));
  		return "/takeroom/takeroomUpdate";
  	}
  	//수정작업
  	@PutMapping("update.do")
  	@ResponseBody
  	public String update(@RequestBody TakeRoom takeroom) throws Exception {
  		takeroomService.update(takeroom);
 // 		System.out.println("takeroom model:"+ takeroom);
  		return "success";
  	}


}
