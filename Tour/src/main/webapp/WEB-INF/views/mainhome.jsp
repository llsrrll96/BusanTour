<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>I'm home</title>
</head>
<body>
<div class="container">

	<div class="container main-img text-center mt-3">

	    	<img class="img-fluid rounded float-start" src="\resources\img\mainimage.jpg"  height="300"  alt="홈으로">
	</div>
	
	<hr>
		<div class="mt-5 mb-5 text-center">
		  <h4>함께하는 부산여행</h4>
		</div>
		
		
	<div class="contanier cards mt-3 d-flex align-content-stretch flex-wrap justify-content-center">
			<c:forEach items="${tourareaDTOs.content }" var="tourareaDTO">
				<div class="card col-4" style="max-width: 18rem;">					
					<div class="card p-1">
					  <img class="card-img-top" src="/resources/img/${tourareaDTO.thumimagefile }" onerror="this.src='/resources/img/basis.jpg'" >
					  
					  <div class="card-body">
					    <h6 class="card-title "><b>${tourareaDTO.title }</b></h6> 
					    <p class="card-text">${tourareaDTO.contents_name }</p> 
					  </div>
					  <button type="button"  onclick="location.href='/tourarea/tourAreaView/${tourareaDTO.contents_id}'" class="btn btn-light"><small>Tour</small></button>
					</div>
					
					
				</div>
			</c:forEach>

	</div>
	

	
		<div class="container button mt-5 mb-5">
				  		 <ul class="pagination justify-content-center mb-5">
				  		 
				  		 	<c:choose>
				  		 		<c:when test="${tourareaDTOs.first}"></c:when>
				  		 		<c:otherwise>
				  		 			<li class="page-item"><a class="page-link" href="/main/?area=${param.area }&divide=${param.divide }&page=0">처음</a></li>
				  		 			<li class="page-item"><a class="page-link" href="/main/?area=${param.area }&divide=${param.divide }&page=${tourareaDTOs.number-1 }">&larr;</a></li>
				  		 		</c:otherwise>
				  		 	</c:choose>
				  		 
				  		 
				  		 			<!-- 페이지 그룹 -->
							<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
								<c:choose>
									<c:when test="${tourareaDTOs.pageable.pageNumber+1 == i}">
										<li class="page-item disabled"><a class="page-link" href="/main/?area=${param.area }&divide=${param.divide }&page=${i-1}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/main/?area=${param.area }&divide=${param.divide }&page=${i-1}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
								<c:when test="${tourareaDTOs.last}"></c:when>
								<c:otherwise>
									<li class="page-item "><a class="page-link" href="/main?area=${param.area }&divide=${param.divide }&page=${tourareaDTOs.number+1}">&rarr;</a></li>
									<li class="page-item "><a class="page-link" href="/main?area=${param.area }&divide=${param.divide }&page=${tourareaDTOs.totalPages-1}">마지막</a></li>
								</c:otherwise>
							</c:choose>
				  		 </ul>
				  		 
				  		 
				  		 
				  <div class="page-button text-xs-center">
	  				  <div class="ms-5 row" >

	
						<form action="/main" method="GET">
							<div class="search input-group  col">
								<div class="input-group-sm col-xs-3">
<!-- 									  <span class="input-group-text form-control col-xs-3" >구군</span> -->
		  			  				<div class="input-group-sm">
									  <button type="button" class="btn btn-secondary  btn-sm input-group-text form-control col-xs-3 dropdown-toggle" data-toggle="dropdown" aria-expanded="false" id="dropdownBtn">
									    구군
									  </button>
									  <ul class="dropdown-menu" id="dropdown-menu" aria-labelledby="dropdownMenuClickable">
										    <c:forEach var="area1" items="${area1 }">
										    	<li ><a class="dropdown-item"  >${area1 }</a></li>
										    </c:forEach>
		    						 </ul>
									</div>
<!-- 				  			  구군을 선택하면 input에 넣는 방식 -->
				  			  </div>
				  				<div class="input-group-sm col-xs-3">
									  <input class=" form-control col-xs-3" type="text" class="form-control" id="area"  name="area" aria-describedby="구군" value="${param.area }" readonly="readonly"
									  
									  style="background-color: transparent;" >
							  </div>

<!-- 							  테마 -->
				 				<div class="input-group-sm col-xs-3 ml-3">
									  <span class="input-group-text form-control" >테마</span>
							  </div>
				 				<div class="input-group-sm col-xs-3 ">
									  <input class="form-control" type="text" class="form-control" id="divide"  name="divide" aria-describedby="테마" value=${param.divide }>
				  			  </div>
				  			  <input type="submit" class="btn btn-outline-info btn-sm col-xs-3 ml-3" value="검색"  id="serach-button">
							</div>
						</form>
							
<!-- 							여행지 쓰기 -->
				  		<button type="button" class="btn btn-light btn-sm ml-5" , onclick="location.href='/tourarea/tourAreaInsert'">여행지 쓰기</button>
							
					</div>
						
				  </div>
				  
				  
	</div>
	
<script>
	
//구군 드랍다운
$("#dropdown-menu li > a").on('click',function(){
	$("#area").val($(this).text());
})
	

</script>

</body>
</html>