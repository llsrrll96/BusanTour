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
import com.tour.app.domain.TakeMember;
import com.tour.app.domain.TakeRoom;
import com.tour.app.service.TakeMemberService;


@RequestMapping("/takemember/*")
@RestController
public class TakeMemberController {
	@Autowired
	private TakeMemberService takememberService;
	
	 //참가자 참가하기  @AuthenticationPrincipal PrincipalDetails principal
	 @PreAuthorize("isAuthenticated()")
	 @PostMapping("entryInsert/{num}") 
	 public ResponseEntity<String>entryInsert(@PathVariable Long num,
			                          @RequestBody TakeMember takemember,
	                         @AuthenticationPrincipal PrincipalDetails principal) {
            //	 System.out.println("principal:"+principal);
	  
            TakeRoom t = new TakeRoom(); 
            t.setNum(num);
            takemember.setTakeroom(t);// takeroom
	  
         	 System.out.println("principal.getUser():"+principal.getMember());
         	 takemember.setMember(principal.getMember()); //member
	 
         	 takememberService.save(takemember);
       return new ResponseEntity<String>("success",HttpStatus.OK); 
	 }

	 @GetMapping("entryList/{num}") 
	 public List<TakeMember> list(@PathVariable Long num){ 
		 List<TakeMember> takememberlist = takememberService.list(num); 
	     return takememberlist; 
	  }
	 //참가자 퇼퇴 취소하기(삭제)
	 @DeleteMapping("delete/{rnum}")
	 public String delete(@PathVariable Long rnum, @AuthenticationPrincipal PrincipalDetails principal) { 
		 takememberService.delete(rnum, principal.getMember().getUserId()); 
	   return "success"; 
	 }
}
