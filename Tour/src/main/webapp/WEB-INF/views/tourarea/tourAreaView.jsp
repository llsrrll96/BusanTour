<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>관광지</title>
</head>
<body>

<%@ include file="../includes/boardCategory.jsp" %>


	<div class="container review-header ">
<!-- 		여행리뷰로 가능 a 태그 -->
		<div class="div_link mt-1">
			<a href="/main" class="link" style = "color: rgb(0, 0, 150);">홈</a>
		</div>
<!-- 		글 제목 -->
		<div class="div_title mt-1">
			<h4 class="title">${tourarea.contentsName }</h4>
		</div>
		
		
<!-- 		글쓴이 정보 -->
		<div class="div_member mt-1">
			<p class="fw-bold"> <strong>${tourarea.member.nickName }</strong></p>
			<div class="date-hitcount">
				<ul class="list-inline"><small>
					  <li class="list-inline-item date text-muted">
					  		<fmt:formatDate value="${tourarea.regdate }" pattern="yyy-MM-dd HH:ss:mm"/>
					  </li>
				</small></ul>
			</div>
		</div>
		
		<p class="fw-bold">${tourarea.area }</p>
		<p class="fw-bold">테마 : ${tourarea.divide }</p>
		<p class="fw-bold">코스 : ${tourarea.course }</p>
		<p class="fw-bold">장소 : ${tourarea.location }</p>
		<hr>
		<div class="container content mt-5 mb-5">
			<p class="fw-bold ">${tourarea.content }</p>
		</div>

	</div>


</div>


</body>
</html>