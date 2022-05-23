package com.tour.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tour.app.domain.Member;
import com.tour.app.repository.MemberJpaRepository;


@Service
public class MemberService 
{
	@Autowired
	MemberJpaRepository memberJpaRepository;
   @Autowired
   private  BCryptPasswordEncoder bCryptPasswordEncoder;
	   
	public void register(Member member) 
	{
		
		String rawPass = member.getPassword();
		String encPass = bCryptPasswordEncoder.encode(rawPass);
		member.setPassword(encPass);
		member.setRole("USER_ROLE");
		member.setWithdraw("1");
		
		
		memberJpaRepository.save(member);
	}
	

}
