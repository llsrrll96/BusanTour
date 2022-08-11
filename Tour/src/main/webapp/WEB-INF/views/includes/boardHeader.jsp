<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 
<title>함께해요 부산여행</title>
</head>
<body>



<nav class="navbar navbar-expand-sm bg-light navbar-light border-bottom">
<div class="container">
  <!--왼쪽 -->
	<ul class="navbar-nav mr-auto ">
			    <li class="nav-item">
			      <a class="navbar-brand" href="/" >
			      	<img src="\resources\img\busan_logo.png"  width="100" height="50" alt="홈으로">
			      </a>
			    </li>
    </ul>
    
    
	<ul class="navbar-nav">
		<sec:authorize access="isAnonymous()">
		    <li class="nav-item">
			      <a class="nav-link" href="/join">회원가입</a>
			    </li>
			<li class="nav-item">
			      <a class="nav-link" href="/login">로그인</a>
			    </li>
		</sec:authorize>
		
		    	<li class="nav-item">
			      <a class="nav-link" href="/manage/manageHome">관리자페이지</a>
			    </li>
			<sec:authorize access="hasRole('ADMIN_ROLE')">
		    	<li class="nav-item">
			      <a class="nav-link" href="/manage/manageHome">관리자페이지</a>
			    </li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			    <li class="nav-item">
			      <a class="nav-link" href="/myBoard/tourReviewList">마이페이지</a>
			    </li>
				<li class="nav-item">
				 <a class="navbar-brand" 	href="/logout">
				   로그아웃(<sec:authentication property="principal.member.name"/>) 
				 </a>
				 </li>	
				</sec:authorize>
			</ul>
	
    
 </div>
</nav>









