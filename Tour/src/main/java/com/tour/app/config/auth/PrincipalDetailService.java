package com.tour.app.config.auth;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tour.app.domain.Member;
import com.tour.app.repository.MemberJpaRepository;

@Service
@Transactional

public class PrincipalDetailService implements UserDetailsService 
{
	@Autowired
//	private UserRepository userRepository;
	private MemberJpaRepository memberJpaRepository;
	
	// login.jsp 에서 로그인 하면 실행 : /login , post
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUserName: "+username);
		Member member= memberJpaRepository.findByName(username); // 해당 값을 DB에서 찾아 user 객체에 저장, 실패시 UserFailHandler
		System.out.println(member.getEmail());
		if(member==null) {
			throw new UsernameNotFoundException(username);
		}
	
		PrincipalDetails puser=new PrincipalDetails(member); //시큐리티의 인증 받은 유저로 변환
		System.out.println("puser: "+puser.toString());
		
		return puser;
	}

}
