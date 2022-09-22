<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

 <div class="container">

<!-- 	페이지 설명 -->
	<div class="alert alert-dismissible alert-light">
	  <strong>당신에게 맞는 여행 모임을 찾아 보세요 !</strong> <br/> <br/>
	  
	  <sec:authorize access="isAuthenticated()">
	  	  <h4><a  href="/tourRoom/roomCreation">모임 개설하기 !</a></h4> 
  	  </sec:authorize>
	  
	  
	</div>

<!-- 찾기 내브바 -->
	<nav class="tournav navbar navbar-expand-lg ">
	    <a class="asearch navbar-brand"  href="">모임 찾기</a>
	    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="navbar-collapse collapse" id="navbarColor03" style="">
	      <ul class="navbar-nav me-auto">
	        <select class="custom-select">
			  <option selected>지역</option>
			  <option value="1">전체</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
			</select>
	
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-sm-2" type="text" placeholder="모임명">
	        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
	      </form>
	  </div>
	</nav>
	
	
	<div class="box">
	    <div class="container">
	     	<div class="row">
				 
<!-- 				 반복-->
				    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
	               
						<div class="box-part text-center">
	                        
	                        <div class="card-body">
							  <h5 class="card-title">title </h5>
							</div>
							
							<svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
							  <rect width="100%" height="100%" fill="#868e96"></rect>
							  <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
							</svg>
							
							<div class="card-body">
							  <p class="card-text">content.</p>
							</div>
							<ul class="list-group list-group-flush">
							  <li class="list-group-item">인원</li>
						 	</ul>	
	                        
						 </div>
					</div>	 
					
					 
			
			</div>		
	    </div>
	</div>
	
	
	
	
	
	
	
</div>
	    

</body>
</html>