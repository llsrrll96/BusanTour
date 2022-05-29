<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/boardHeader.jsp" %>



<head>
<meta charset="UTF-8">
<title>여행 리뷰 상세보기</title>
</head>
<style>
*{
magin: 0px;
padding: 0px;
text-decoration: none;
}
.main-img {
width: 100%;
	height: 315px;
border-bottom: thick double #32a1ce;
text-align: center;
}

</style>
<body>


<div class="container root border-dark" >

	<div class="container review-header ">
	<div class="main-img">

	    	<img class="top-img" src="\resources\img\mainimage.jpg"  >
	    	
</div><br><br><br>
<!-- 		여행리뷰로 가능 a 태그 -->
		<div class="div_link mt-1">
			<a href="../../tourreview/tourreviewList" class="link" style = "color: rgb(0, 0, 150);">여행 리뷰</a>
		</div>
<!-- 		글 제목 -->
		<div class="div_title mt-1">
			<h4 class="title">${reviewBoard.title }</h4>
		</div>
		<div class="div_member mt-1">
			<p class="fw-bold"> <strong>${reviewBoard.member.nickName }</strong></p>
			<div class="date-hitcount">
				<ul class="list-inline"><small>
					  <li class="list-inline-item date text-muted">
					  		<fmt:formatDate value="${reviewBoard.regdate }" pattern="yyy-MM-dd HH:ss:mm"/>
					  </li>
					  <li class="list-inline-item hitcount text-muted">조회 ${reviewBoard.hitcount }</li>
				</small></ul>
			</div>
		</div>
<!-- 		글쓴이 정보 -->
	</div>
	<hr/>
	<div class="row review-main">
<!-- 		내용 -->
		<div class="container contents">
			<p class="text">
				${reviewBoard.contents }
			</p>
		</div>

	</div>	


</div>



</body>
</html>