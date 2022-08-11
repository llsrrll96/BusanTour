package com.tour.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.app.config.auth.PrincipalDetails;
import com.tour.app.domain.TakeComment;
import com.tour.app.domain.TakeRoom;
import com.tour.app.service.TakeCommentService;


@RequestMapping("/takecomment/*")
@RestController
public class TakeCommentController {

	@Autowired
	private TakeCommentService takecommentService;
		
	@PreAuthorize("isAuthenticated()")
	@PostMapping("takecommentInsert/{num}")
//	public String insert(@PathVariable Long num,
	public ResponseEntity<String>takecommentInsert(@PathVariable Long num,
		@RequestBody TakeComment takecomment,
		@AuthenticationPrincipal PrincipalDetails principal) {
	    //System.out.println("principal:"+principal);
//		if(principal == null) {
//			return new ResponseEntity<String>("fail",HttpStatus.FAILED_DEPENDENCY);
//		}
		TakeRoom tr = new TakeRoom();
		tr.setNum(num);
		takecomment.setTakeroom(tr); //takeroom
			
		System.out.println("principal.getMember():"+principal.getMember());
		takecomment.setMember(principal.getMember()); //사용자 ID 저장용
			
		takecommentService.save(takecomment);
		return new ResponseEntity<String>("success",HttpStatus.OK);
//		return null;
	 }
	//전체조회
	 @GetMapping("commentList/{num}")
	 public List<TakeComment> list(@PathVariable Long num){
		System.out.println("num :" + num);
		List<TakeComment> clist = takecommentService.list(num);
		return clist;
	 }
	//삭제
	@DeleteMapping("commentDelete/{cnum}")
	public Long delete(@PathVariable Long cnum) {
		takecommentService.delete(cnum);
	return cnum; 
	}

}
