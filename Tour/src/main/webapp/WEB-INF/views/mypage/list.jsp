<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<html>
<body>
<div class="container ">
	<h2>마이페이지리스트(${count })</h2>
	

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myBoards}" var="myboard" varStatus="st">
				<tr>
					<td>${myboard.num}</td>
					<td><a href="/mypage/view/${myboard.num}">${myboard.title }</a></td>
					<td>${myboard.writer }</td>
					<td> <fmt:formatDate value="${myboard.regdate}" pattern="yyyy-MM-dd-HH-mm-ss"/></td> 	
					<td>${myboard.hitcount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>