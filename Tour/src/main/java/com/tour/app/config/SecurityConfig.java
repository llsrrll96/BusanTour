package com.tour.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tour.app.config.auth.UserFailHandler;

//환경설정 파일

@Configuration
//매 Request는 스프링 시큐리티의 필터들을 거친다. 우리는 개발하면서 어떤 request에 어떤 Filter가 호출되는지의 과정을 확인하고 싶을때가 있는데, 이때 아래 어노테이션을 선언하자.
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)   // @PreAuthorize("isAuthenticated()")  사용
public class SecurityConfig extends WebSecurityConfigurerAdapter // 시큐리티  
{
	@Autowired
	private UserFailHandler userFailHandler;
	@Bean
	public BCryptPasswordEncoder encodePwd() { // 패스워드 암호화 빈 등록
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // 의도된 웹 사이트 요청 공격
		http.authorizeRequests()  //권한
				.antMatchers("/user/*").authenticated()    // /user 으로 넘어오는 url 은 인증
				.antMatchers("/tourarea/tourAreaInsert").authenticated()
				.antMatchers("/manage/*").hasAuthority("ROLE_ADMIN")
				.anyRequest().permitAll()
			.and()
				.formLogin()
				.loginPage("/login") // 커스텀 페이지
				.loginProcessingUrl("/login")
				.failureHandler(userFailHandler)
				.defaultSuccessUrl("/main")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/main") // 성공시
				.invalidateHttpSession(true); //세션 해제
		
		
	}
	
	

}
