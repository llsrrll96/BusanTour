<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="container">
 
 	<div >
	    <div class="d-flex h-45  align-items-center flex-column mt-3 mb-3"  style="font-size:37px">
			<div class="title mb-auto p-2 bd-highlight" name="title" id="title">${tourarea_title }</div>
	    <div class="mt-3 mb-3"  >
	      	<img src="/resources/img/${tourarea_imagefile }"  class="img-fluid img-rounded"  width="700"  alt="메인 이미지">
		    
		</div> 
	</div>
<!-- 게시물의 중간 카테고리 텝 -->
	<div class="catagory">
		<ul class="nav justify-content-center border-bottom">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="/tourarea/tourAreaView/${tourarea_contentsId }">상세 정보</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/tourreview/tourreviewList/">여행 리뷰</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/takeroom/takeroomList/">여행 참여</a>
		  </li>
		</ul>
	</div>
	
	
	
	
	
	
</div>
	