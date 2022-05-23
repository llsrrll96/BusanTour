package com.tour.app.config.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class UserFailHandler implements AuthenticationFailureHandler
{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("UserFailHandler");
		
		//로그인 실패 로직 처리
		request.setAttribute("errorMsg", "이름과 비밀번호를 확인 후 다시 로그인하여 주시기 바랍니다.");
		
		
		
		
		
		request.getRequestDispatcher("/login?error=true").forward(request, response); // 값을 전달하여 페이지 이동
	}

}
