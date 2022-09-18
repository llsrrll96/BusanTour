package com.tour.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tour.app.domain.Member;
import com.tour.app.dto.MemberDTO;
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
		if(rawPass.equals("admin1234!")) member.setRole("ROLE_ADMIN");
		else member.setRole("ROLE_USER");
		
		String encPass = bCryptPasswordEncoder.encode(rawPass);
		member.setPassword(encPass);
		
		memberJpaRepository.save(member);
	}

	public List<Member> getMemberList() {
		return memberJpaRepository.findAll();
	}
	public List<MemberDTO> getMemberDTOList() {
		return memberJpaRepository.findAllMemberDTO();
	}
	
	public Long getMemberCount() {
		return memberJpaRepository.count();
	}

	@Transactional
	public void updateMemberRole(String name, String role) 
	{
		Member member= memberJpaRepository.findByName(name);
		member.setRole(role);
	
	}
	
	@Transactional
	public void updateMemberWithdraw(String name) 
	{
		Member member= memberJpaRepository.findByName(name);
		if(member.getWithdraw().equals("0")) member.setWithdraw("1");
		else member.setWithdraw("0");
	}

}
