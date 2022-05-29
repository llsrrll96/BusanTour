<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../includes/header.jsp"%> 
<div class="container">
   <sec:authorize access="isAuthenticated()">
		<input type="hidden" id="prname" name="prname"
			value='<sec:authentication property="principal.member.name"/>' />
	    <input type="hidden" id="prnickname" name="prnickname"
			   value='<sec:authentication property="principal.member.nickName"/>' />
   </sec:authorize> 

  <h3>함께해요! 추천여행 참가클럽을 오픈합니다.</h3>
    <%-- <input type="hidden" name="userid" id="userid" value="${takeroom.member.userId }" />  --%>
    <%--  value="${principal.member.nickName}"  --%>
    <input type="hidden" name="contentsId" id="contentsId" value="${takeroom.tourarea.contentsId }" /> 
    <div class="form-group">
      
    </div>
    <div class="form-group">
      <label for="nickname">여행가이드:</label>
      <input type="text" class="form-control" id="nickname" name="nickname"  
             value='<sec:authentication property="principal.member.nickName"/>'  readonly="readonly">
     <%--  <input type="text" class="form-control" id="nickname" name="nickname"  value="${principal.member.nickName}" > --%>
     <%--  readonly="readonly" 보안인증 작업시 readonly로 변경예정  <sec:authentication property="principal.member.name"/> --%>
    </div>
    
    <div class="form-group">
      <label for="title">참여여행:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter 참여여행 주제 및 테마" name="title">
    </div>
    
    <div class="form-group">
	  <label for="content">공지사항:</label>
		<textarea class="form-control" rows="5" name="content" id="content" placeholder="Enter 참여여행 공지사항 / 여행지 / 약속장소와 시간  "></textarea>
	</div>
       
    <div class="form-group">
      <label for="startDate">모집 시작일자:</label>
      <!-- <input type="datetime-local" class="form-control" id="startDate" value="yyyy-MM-ddThh:mm" name="startDate"> -->
      <input type="date" class="form-control" id="startDate"  name="startDate" value="startDate" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="endDate">모집 마감일자:</label>
      <!-- <input type="datetime-local" class="form-control" id="endDate" value="yyyy-MM-ddThh:mm" name="endDate"> -->
      <input type="date" class="form-control" id="endDate"  name="endDate" value="endDate">
    </div>
    
    <div class="form-group">
      <label for="openyn">마감여부:</label>
      <input  type="radio" name="openyn" id="openyn" value="Y" checked>오픈
	  <input  type="radio" name="openyn" id="openyn" value="N" ">마감 
    </div>
    
    <button type="button" class="btn btn-outline-primary" id="btnJoin">참가여행 클럽 오픈하기</button>

</div>  
<script>
//모집시작일자에 오늘날짜와 시간값 자동입력
//document.getElementById('startDate').value= new Date().toISOString().slice(0, 16);
document.getElementById('startDate').valueAsDate= new Date();

$("#btnJoin").click(function(){
  if($("#title").val()==""){
	 alert("참여여행 제목을 입력하세요") 
	 $("#title").focus();
	 return false;	  
   }
  if($("#content").val()==""){
		 alert("공지사항을 입력하세요") 
		 $("#content").focus();
		 return false;	  
	   }
  if($("#nickname").val()==""){
		 alert("여행 가이드를 입력하세요") 
		 $("#nickname").focus();
		 return false;	  
   }
//  if($("#contentsId").val()==""){
//		 alert("추천 여행지를 입력하세요") 
//		 $("#contentsId").focus();
//		 return false;	  
//   }
  if($("#startDate").val()==""){
		 alert("모집 시작일자를 입력하세요") 
		 $("#startDate").focus();
		 return false;
  }
  if($("#endDate").val()==""){
		 alert("모집 마감일자를 입력하세요") 
		 $("#endDate").focus();
		 return false;
  }
  if ($("input:radio[name=openyn]:checked").length == 0) {
				alert("마감여부를 선택하세요")
		 return false;	 
  }
//  alert($("#endDate").val())
  var dataParam={
      "title" : $("#title").val(),
      "content" : $("#content").val(),
      "nickname" : $("#nickname").val(),
//      "contentsId" : $("#contentsId").val(),
      "startDate" : $("#startDate").val(),
      "endDate" : $("#endDate").val(),
//      "endDate" : $("input:date[name=endDate]").val(),
      "openyn" : $("input:radio[name=openyn]:checked").val()
  }
  $.ajax({
	 type: "POST",
	 url: "insert",
	 contentType:"application/json;charset=utf-8",
	 data:JSON.stringify(dataParam)	  
  })
  .done(function(resp){
	  alert("함께 추천여행 개설 성공하였습니다.");
	  location.href="/takeroom/list"
	 if(resp=="fail"){
		 alert("추천여행 개설이 잘 못 되었습니다1.")
		 $("#title").val("")
	 }  
  })
  .fail(function(){
	  alert("추천여행 개설이 잘 못 되었습니다2.")
  })
}) //btnJoin


</script>
</body>
</html>