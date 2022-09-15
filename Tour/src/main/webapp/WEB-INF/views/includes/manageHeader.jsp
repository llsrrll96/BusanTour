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
 
 <link rel="stylesheet" type="text/css" href="../resources/css/manageHome_css.css"/>
 
<title>관리 페이지</title>
</head>
<body>


 <!-- Sidebar -->
 <header>
  <nav
       id="sidebarMenu"
       class="collapse d-lg-block sidebar collapse bg-white"
       >
    <div class="position-sticky">
      <div class="list-group list-group-flush mx-3 mt-4">
        <!-- Collapse 1 -->
        <a
           class="list-group-item list-group-item-action py-2 ripple"
           aria-current="true"
           data-mdb-toggle="collapse"
           href="#collapseExample1"
           aria-expanded="true"
           aria-controls="collapseExample1"
           >
          <i class="fas fa-tachometer-alt fa-fw me-3"></i
            ><span><b>관리 메뉴</b></span>
        </a>
        <!-- Collapsed content -->
        <ul
            id="collapseExample1"
            class="collapse show list-group list-group-flush"
            >
          <li class="list-group-item py-1">
            <a href="/manage/manageMember" class="text-reset">멤버 관리</a>
          </li>
          <li class="list-group-item py-1">
            <a href="/manage/manageBoard" class="text-reset">전체 글 관리</a>
          </li>
          <li class="list-group-item py-1">
            <a href="/manage/manageAPI" class="text-reset">API 관리</a>
          </li>
          <li class="list-group-item py-1">
            <a href="" class="text-reset">Link</a>
          </li>
        </ul>
        <!-- Collapse 1 -->

      </div>
    </div>
  </nav>
  <!-- Sidebar -->		


	<nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
	<div class="container-fluid">
	  <!--왼쪽 -->
		<ul class="navbar-nav mr-auto">
				    <li class="nav-item">
				      <a class="navbar-brand" href="/manage/manageHome">HOME</a>
				    </li>
	
	
	    
	    </ul>
	 			<!-- 오른쪽 -->
		<!-- 			  로그인 -->
		<ul class="navbar-nav">
		    <li class="nav-item">
		      <a class="nav-link" href="/myBoard/tourReviewList">마이페이지</a>
		    </li>
			<sec:authorize access="isAnonymous()">
			    <li class="nav-item">
				      <a class="nav-link" href="/join">회원가입</a>
				    </li>
				<li class="nav-item">
				      <a class="nav-link" href="/login">로그인</a>
				    </li>
			</sec:authorize>
	
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item">
					 <a class="navbar-brand" 	href="/logout">
					   로그아웃(<sec:authentication property="principal.member.name"/>) 
					 </a>
					 </li>	
					</sec:authorize>
				</ul>
		
	    
	 </div>
	</nav>
</header>









