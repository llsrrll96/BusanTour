package com.tour.app.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tour.app.domain.Member;

import lombok.Data;
import lombok.NoArgsConstructor;


//User 는 id , password, 권한 뿐이고 UserDetails 은 더 많은 요소로 인증 절차를 할 수 있다.
@NoArgsConstructor
@Data
public class PrincipalDetails  implements UserDetails
{
	private Member member;

	public PrincipalDetails(Member member) {
		super();
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(()->{
			return member.getRole();
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return  member.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getName();
	}
	public String getNicname() {
		return member.getNickName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
