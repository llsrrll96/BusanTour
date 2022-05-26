<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>tourreviewList</title>
</head>
<body>

<%@ include file="../includes/boardCategory.jsp" %>

<div class="container root" id="root" >

<!-- style="background-color: red;" -->
<!-- 회원만 -->
<div class="row review-header">
	<h4 class="display-6 mt-3 col-8 align-self-start">여행 리뷰</h4>
	<button type="button" class="btn btn-light col-4 align-self-end" , onclick="location.href='/tourreview/tourreviewForm'">여행 리뷰 쓰기</button>
</div>
	<div class="reviewTable">
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Num</th>
			      <th scope="col">제목</th>
			      <th scope="col">작성자</th>
			      <th scope="col">작성일</th>
			      <th scope="col">조회</th>
			    </tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="reviewBoards" items="${reviewBoards }">
			  			<tr>
			  				<th scope="row">${reviewBoards.num }</th>
			  				<td><a href="/tourreview/tourreviewView/${reviewBoards.num }">${reviewBoards.title }</a></td>
			  				<td>${reviewBoards.nick_name }</td>
			  				<td>${reviewBoards.regdate }</td>
			  				<td>${reviewBoards.hitcount }</td>
			  			</tr>
			  		</c:forEach>
<!-- 			    <tr> -->
<!-- 			      <th scope="row">1</th> -->
<!-- 			      <td>Mark</td> -->
<!-- 			      <td>Otto</td> -->
<!-- 			      <td>@mdo</td> -->
<!-- 			    </tr> -->
<!-- 			    <tr> -->
<!-- 			      <th scope="row">2</th> -->
<!-- 			      <td>Jacob</td> -->
<!-- 			      <td>Thornton</td> -->
<!-- 			      <td>@fat</td> -->
<!-- 			    </tr> -->
<!-- 			    <tr> -->
<!-- 			      <th scope="row">3</th> -->
<!-- 			      <td colspan="2">Larry the Bird</td> -->
<!-- 			      <td>@twitter</td> -->
<!-- 			    </tr> -->
			  </tbody>
			</table>
	</div>
</div>



</body>



</html>

