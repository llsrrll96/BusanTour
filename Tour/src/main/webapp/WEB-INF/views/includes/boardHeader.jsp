<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
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

<link rel="stylesheet" type="text/css" href="../resources/css/tourRoom/tourRoom_css.css"/>
<link rel="stylesheet" type="text/css" href="../resources/css/tourRoom/roomCreation_css.css"/>

<title>함께해요 부산여행</title>
<style>
.nav-link{
  font-weight: bold
}
</style>
</head>
<body>



<nav class="navbar navbar-expand-sm  navbar-light border-bottom">
<div class="container">
  <!--왼쪽 -->
	<ul class="navbar-nav mr-auto ">
			    <li class="nav-item">
			      <a class="navbar-brand" href="/" >
			      	<img src="\resources\img\busan_logo.png"  width="100" height="40" alt="홈으로">
			      </a>
			    </li>
			    
   			    <li class="nav-item mt-2">
			      <a class="nav-link" href="/tourRoom/tourRooms">여행 모임</a>
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
		
			<sec:authorize access="hasRole('ROLE_ADMIN')">
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









