<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<h5>${takeroom.nickname }의 추천여행 클럽 수정 및 마감하기</h5>
	<input type="hidden" name="num" id="num" value="${takeroom.num }" /> 
	<div class="form-group">
		    <label for="num">여행클럽:</label> <input type="text" class="form-control"
			       id="num" name="num" value="${takeroom.num }" readonly="readonly">
	</div>
	<div class="form-group">
      <label for="title">참여여행:</label>
      <input type="text" class="form-control" id="title" name="title" value="${takeroom.title }" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="contentsId">여행테마:</label>
      <input type="text" class="form-control" id="contentsId" name="contentsId"  value="${takeroom.tourarea.divide }" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="membercnt">참여인원:</label>
      <input type="text" class="form-control" id="membercnt" name="membercnt" value="${takeroom.membercnt}" readonly="readonly" >
    </div>
    
    <div class="form-group">
	  <label for="content">공지사항</label>
		  <textarea class="form-control" rows="5" id="content" name="content" >${takeroom.content }</textarea>
	  </div>
    
    <div class="form-group">
      <label for="nickname">여행가이드:</label>
      <input type="text" class="form-control" id="nickname" name="nickname" value="${takeroom.nickname }" readonly="readonly"/>
    </div>
    
<%-- <div class="form-group">
      <label for="startDate">모집 시작일자:</label>
      <input type="text" class="form-control" id="startDate" name="startDate" fmt:formatDate value="${takeroom.startDate}" pattern="yyyy-MM-dd hh:mm " readonly="readonly" >
    </div> --%>
    
    <div class="form-group">
      <label for="endDate">모집 마감일자:</label>
      <input type="text" class="form-control" id="endDate" name="endDate" fmt:formatDate value="${takeroom.endDate}" readonly="readonly" / >
    </div>
     
    <div class="form-group">
      <label for="openyn">마감여부:</label>
       <input type="text" class="form-control" id="openyn" name="openyn"  value="${takeroom.openyn }"/ >
      <!--  pattern="[A-Za-z]+$" -->
    </div>
    
	
		  <div class="form-group text-right">
		        <button type="button" class="btn btn-outline-secondary" id="btnModify">수정</button>
		  </div>
</div>
<script>
$("#btnModify").click(function(){
	alert($("#content").val());
	data = {
		"num" : $("#num").val(),	
		"title" : $("#title").val(),
	    "content" : $("#content").val(),
//	    "endDate" : $("#endDate").val(),   //String ---> Date타입으로 형변환 필요, Date.parse
	    "openyn" : $("#openyn").val()	 
	}
	$.ajax({
	  type:"put",
	  url:"/takeroom/update.do",
	  contentType:"application/json;charset=utf-8",
	  data:JSON.stringify(data),
	  success:function(resp){
		  if(resp=="success"){
			  alert("수정이 잘 되었습니다.");
			  location.href="/takeroom/list"
		  }//if
	  }//success		
	})//ajax
	.fail(function(e){
		  alert("수정이 잘 못 되었습니다.:" + e)
	})
})//btnModify
</script>
</body>
</html>