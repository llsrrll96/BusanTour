<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/boardHeader.jsp" %>


<head>
<meta charset="UTF-8">
<title>여행 리뷰 상세보기</title>
</head>
<body>
<%@ include file="../includes/boardCategory.jsp" %>

<div class="container root border-dark" >

	<div class="container review-header ">
<!-- 		여행리뷰로 가능 a 태그 -->
		<div class="div_link mt-1">
			<a href="../../tourreview/tourreviewList" class="link" style = "color: rgb(0, 0, 150);">여행 리뷰</a>
		</div>
<!-- 		글 제목 -->
		<div class="div_title mt-1 d-flex justify-content-between">
			<div class="">
				<h4 class="title">${reviewBoard.title }</h4>
			</div>
			<div class="justify-content-end">
				<!-- Example single danger button -->
<!-- 				시큐리티 적용 -->
			<c:if test="${reviewBoard.member.userid eq sessionUserid }">
				<div class="btn-group">
				  <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false" id="dropdownBtn">
				    편집하기
				  </button>
				  <ul class="dropdown-menu">
				    <li><a class="dropdown-item" href="/tourreview/tourreviewUpdateForm/${reviewBoard.boardId }/${reviewBoard.num}">수정하기</a></li>
				    <li><a class="dropdown-item btn-danger" href="javascript:deleteBoard(${reviewBoard.num })">삭제하기</a></li>
				  </ul>
				</div>
			</c:if>


			</div>
		</div>
		<div class="div_member mt-1 ">
			
				<p class="fw-bold"> <strong>${reviewBoard.member.nickName }</strong></p>
				<div class="date-hitcount">
					<ul class="list-inline"><small>
						  <li class="list-inline-item date text-muted">
						  		<fmt:formatDate value="${reviewBoard.regdate }" pattern="yyy-MM-dd HH:ss:mm"/>
						  </li>
						  <li class="list-inline-item hitcount text-muted">조회 ${reviewBoard.hitcount }</li>
					</small></ul>
			
			
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

<script>
function deleteBoard(num)
{
	if(confirm("삭제 하시겠습니까?") == true)
	{
		$.ajax({
			type:"delete",
			url:"/tourreview/delete/${reviewBoard.num}",
			success:function(resp){
				location.href="/tourreview/tourreviewList"
			},
			error:function(e){
				alert("삭제 실패")
			}
		})
	}
	return;

}
</script>


</body>
</html>