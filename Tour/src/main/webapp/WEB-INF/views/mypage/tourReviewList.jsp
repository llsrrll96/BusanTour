<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
<style>
*{
	text-decoration: none;
	
}
.bd-sidebar {
  position: sticky;
  top: 4rem;
  z-index: 1000;
  height: calc(100vh - 4rem);
  background: azure;
  border-right: 1px solid rgba(0,0,0,.1);
  overflow-y: auto;
  min-width: 160px;
  max-width: 220px;
}
.bd-sidebar .nav {
  display: block;
}
.bd-sidebar .nav>li>a {
  display: block;
  padding: .25rem 1.5rem;
  font-size: 90%;
  
}
.top-img {
	position: absolute;
    margin-left: 500px;
	width: 60%;
    height: 300px;
    background-color: #8a8;
    background-size: 100% 100%;  
}
.main-img{

}
.main {
	width: 100%;
	height: 315px;
	border-bottom: thick double #32a1ce;
	
}
.main > .container {
	position: absolute;
	top: 350px;
	margin-left: 280px;	
}
.nav > li {
color: black;
font-weight: 600;
}

</style>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>

<div class="main-img">

	    	<img class="top-img" src="\resources\img\mainimage.jpg"  >
</div>

<div class="container-fluid">
  <div class="row flex-nowrap">
    <div class="col-3 bd-sidebar">
      <ul class="nav"> 
      </br>
      </br>
        <li><h2>마이페이지</h2></span></li> 
        <li><a href="/myBoard/tourReviewList">내가 쓴 여행 리뷰</a></li>
        <li><a href="/myBoard/takeRoomList">내가 쓴 참여 모집 글</a></li>
      </ul>
      <br>
    </div>
    <br><br><br>
    <main class="main" role="main">
      <div class="container ">
      <br><br>
	<h2>내가 쓴 여행 리뷰</h2><br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>	
				<th>지역</th>
				<th>테마</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reviewBoards" items="${reviewBoards }">
	  			<tr>
	  				<th scope="row">${reviewBoards.num }</th>
	  				<td><a href="/myBoard/tourreviewView/${reviewBoards.num }">${reviewBoards.title }</a></td>
	  				<td>${reviewBoards.area1 }</td>
	  				<td>${reviewBoards.divide }</td>
	  				<td> <fmt:formatDate value="${reviewBoards.regdate}" pattern="yyyy.MM.dd. HH:mm"/></td> 	
	  				<td>${reviewBoards.hitcount }</td>
	  			</tr>
	  		</c:forEach>
		</tbody>
	</table>
	
    </main>
  </div>
</div>