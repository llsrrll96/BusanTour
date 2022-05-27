<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

  <div class="container">
  	<div class="mt-3 mb-3">
	  <h4>부산 관광지</h4>
	</div>
	
  <form action="tourAreaInsert" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="contentsName">콘텐츠 명</label>
      <input type="text" class="form-control" id="contentsName" placeholder="Enter 콘텐츠 명" name="contentsName">
    </div>
<!--     <div class="form-group"> -->
<!--       <label for="pwd">글쓴이:</label> -->
<!--       <input type="text" class="form-control" id="writer"  -->
<!--       placeholder="Enter writer" name="writer" > -->
<!--     </div> -->

     <div class="form-group">
       <label for="area">지역</label>
      <div class="btn-group dropdown">
		  <button class="btn btn-secondary dropdown-toggle " type="button" id="area1" name="area1" data-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">
		  부산전체
		  </button>
		  <ul class="dropdown-menu dropdown" id="dropdown-menu" aria-labelledby="dropdownMenuClickable">
		    <c:forEach var="area1" items="${area1 }">
		    	<li ><a class="dropdown-item"  >${area1 }</a></li>
		    </c:forEach>
		  </ul>
	      <input type="hidden" class="form-control" id="area"  name="area"  value="부산전체">
 
	</div>
    
     <div class="form-group">
      <label for="location">장소</label>
      <input type="text" class="form-control" id="location" placeholder="Enter 장소" name="location">
    </div>
    
     <div class="form-group">
      <label for="divide">테마</label>
      <input type="text" class="form-control" id="divide" placeholder="Enter 테마" name="divide">
    </div>
    
     <div class="form-group">
      <label for="course">코스 명</label>
      <input type="text" class="form-control" id="course" placeholder="Enter 코스" name="course">
    </div>
    
     <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" placeholder="Enter 제목" name="title">
    </div>
    

    <div class="form-group">
      <label for="thumimage_url">썸네일:</label>
      <input type="file" class="form-control" id="thumimage_url" 
      placeholder="Enter 썸네일" name="thumimage_url">
    </div>
    
    <div class="form-group">
      <label for="image_url">파일:</label>
      <input type="file" class="form-control" id="imageUrl" 
      placeholder="Enter 이미지" name="imageUrl">
    </div>
    
    
     <div class="form-group">
      <label for="content">내용</label>
     <textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    
    
    <div class="form-group text-right">
      <button type="submit" class="btn btn-primary btn-sm">글쓰기</button>
     </div> 
  </form>
</div>
<script>
$("#area1").text("부산전체"); //초기값
$("#dropdown-menu li > a").on('click',function(){
	$("#area1").text($(this).text());
	$("#area").val($(this).text());

})
</script>