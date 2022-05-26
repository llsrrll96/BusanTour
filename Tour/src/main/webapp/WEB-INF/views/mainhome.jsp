<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="includes/header.jsp" %>

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
			<c:forEach items="${tourareaDTOs }" var="tourareaDTO">
			
				<div class="card col-4" style="max-width: 15rem;">					
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
	
	
	
	
	
	
	
	
	
	<div class="container button d-flex justify-content-end mt-5 mr-3">
		<div class="">
			<button type="button" class="btn btn-light " , onclick="location.href='tourarea/tourAreaInsert'">여행지 쓰기</button>
		</div>
	</div>
</div>
	
	
</body>
</html>