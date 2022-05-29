<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
      div.strow {
        width: 100%;
        display: flex;
        border: 0.1px solid #F5F6CE;
      }
      div.stleft {
        width: 50%;
        float: left;
        box-sizing: border-box;
        background: #FAFAFA;
      }
      div.stright {
        width: 50%;
        float: right;
        box-sizing: border-box;
        background: #FAFAFA;
      }
</style>

<div class="container">	

   <div class="container-fluid">
   <br>
   <div class="card bg-success text-white">
    <div class="card-body">
   <h5>#<${takeroom.nickname }>의 추천여행 클럽 참여하기</h5>
   <p>함께하는 추천여행 마음의 여유를 가지고 즐거운 여행을 찾아서 떠나요.</p></div>
   </div>
   <br>
   <%-- <input type="hidden" name="userid" id="userid" value="${takeroom.member.userId }" />  --%>
   <div class="row">
    <div class="col-sm-3"  style="background-color:#f8f8ff;">
         <label for="num">여행클럽:</label> <input type="text" class="form-control"
			       id="num" name="num" value="${takeroom.num }" readonly="readonly"></div>
    <div class="col-sm-3" style="background-color:#f8f8ff;">
         <label for="title">참여여행:</label>
         <input type="text" class="form-control" id="title" name="title" value="${takeroom.title }" readonly="readonly"></div>
    <div class="col-sm-3" style="background-color:#f8f8ff;">
         <label for="contentsId">여행테마:</label>
         <input type="text" class="form-control" id="contentsId" name="contentsId"  value="${takeroom.tourarea.divide }" readonly="readonly"></div>
    <div class="col-sm-3" style="background-color:#f8f8ff;">
         <label for="membercnt">참여인원:</label>
         <input type="text" class="form-control" id="membercnt" name="membercnt" value="${takeroom.membercnt}" readonly="readonly" ><br></div>
         
    <div class="col-md-3" style="background-color:#f8f8ff;">
         <label for="nickname">여행가이드:</label>
         <input type="text" class="form-control" id="nickname" name="nickname" value="${takeroom.nickname }" readonly="readonly"/></div>
    <div class="col-md-3" style="background-color:#f8f8ff;">
         <label for="startDate">모집 시작일자:</label>
         <input type="text" class="form-control" id="startDate" name="startDate"  value="${takeroom.startDate}" pattern="yyyy-MM-dd hh:mm " readonly="readonly" ></div>
    <div class="col-md-3" style="background-color:#f8f8ff;">
         <label for="endDate">모집 마감일자:</label>
         <input type="text" class="form-control" id="endDate" name="endDate"  value="${takeroom.endDate}" pattern="yyyy-MM-dd hh:mm " readonly="readonly" ></div>
    <div class="col-md-3" style="background-color:#f8f8ff;">
         <label for="openyn">마감여부:</label>
         <input type="text" class="form-control" id="openyn" name="openyn"  value="${takeroom.openyn }" readonly="readonly"><br></div>
  </div>
  <br>
  <div class="row">
    <div class="col-xl-2" style="background-color:#f8f8ff;"><label for="content">공지사항</label></div>
    <div class="col-xl-10" style="background-color:#f8f8ff;">
         <textarea class="form-control" rows="5" id="content" name="content" readonly="readonly">${takeroom.content }</textarea><br></div>
  </div>
  
  </div>
    
 
		  <div class="form-group text-right">
		    <%--  <sec:authorize access="isAuthenticated()">  	 --%>

	          <c:if test="${principal.member.username == takeroom.member.name }"> 
		        <button type="button" class="btn btn-outline-secondary" id="btnUpdate">수정</button>
                <button type="button" class="btn btn-outline-info" id="btnDelete" >여행클럽삭제</button>
             </c:if> 
          <%--    </sec:authorize>  --%>
		  </div>
      
	    <br/><br/>
  
  
  <div class="form-group text-left" style="width: 50%; height:auto; border:0.5px solid white; float: left;">
     <button type="button" class="btn btn-outline-secondary" id="btnEntrylist">참가자</button>
     <button type="button" class="btn btn-outline-primary" id="btnEntry">추천여행 참여하기</button>
     <button type="button" class="btn btn-outline-primary" data-toggle="collapse" data-target="#demo" id="btnReply">댓글</button>
  </div>
  <div class="form-group text-right" align="right" style="width: 50%; height:auto; border:0.5px solid white; float: right;">
    <a href="/takeroom/insert">
        <sec:authorize access="isAuthenticated()">
		 <button type="button" class="btn btn-primary btn-sm" id="insertBtn">함께해요! 여행클럽 오픈</button>
		</sec:authorize>
	</a>
  </div>

  <div id="demo" class="collapse">
	    <div align="center">
	    <label for="takemember">댓글내용</label> 
 		    <textarea rows="2" cols="140" id="msg" name="msg"></textarea>   
		    <button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
  </div>

<div class="strow">
      <div class="stleft">
        <table class="table table-hover">
           <thead>
           <tr>
              <th>여행클럽</th>
              <th>참여자ID</th>
              <th>별칭</th> 
              <th>참여여부</th>
              <th>신청일자</th>
           </tr>
           </thead>
           <tbody>
     <%--   <c:forEach items="${takerooms}"  var="takeroom" varStatus="st"> 
             <tr>
               <td>${takeroom.num}</td>
               <td><a href="view/${takeroom.num }">${takeroom.member.userId }</a></td>
               <td>${takeroom.member.userId}</td>   
               <td>${takeroom.takemember.entrant)}</td>
               <td>${takeroom.takemembers.takeyn.val()}</td> 
               <td><fmt:formatDate value="${takeroom.takemembers.regdate.val()}" pattern="yyyy-MM-dd" /></td>            
              </tr>  
            </c:forEach>  --%>
            </tbody>   
          </table> 
        왼쪽<br>
        왼쪽<br>
        왼쪽<br>
        왼쪽<br>
        왼쪽<br>
        왼쪽<br>
        왼쪽<br>
        참가자 리스트<br>
        <hr/>
	    <div id="entryList"></div>
      </div>
      <div class="stright">
          <table class="table table-hover">
           <thead>
           <tr>
              <th>번호</th>
              <th>내용</th>
              <th>작성자</th> 
              <th>작성일자</th>
              <th>조회건수</th>
           </tr>
           </thead>
           <tbody>
 <%--        <c:forEach items="${takeroom}"  var="takeroom" varStatus="st"> --%>
 <%--        <tr>
               <td>${takeroom.num}</td>
               <td><a href="view/${takeroom.num }">${takeroom.member.userId }</a></td>
               <td>${takeroom.member.userId}</td>   
               <td>${takeroom.takemember.entrant)}</td>
               <td>${takeroom.takemembers.takeyn.val()}</td> 
               <td><fmt:formatDate value="${takeroom.takemembers.regdate.val()}" pattern="yyyy-MM-dd" /></td>            
              </tr>  --%>
<%--          </c:forEach> --%>
            </tbody>   
          </table> 
          댓글리스트<br>
          <hr/>
	    <div id="replyResult"></div>
      </div>
    </div>
  
	
       <br>
       <div>
	    <div align="center">
	    <label for="takemember">댓글쓰기</label> 
 		    <textarea rows="2" cols="140" id="msg" name="msg"></textarea>   
		    <button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
	    </div>
	    <hr/>
</div>


<%--  <table class="table table-hover">
  <thead>
     <tr>
       <th>참여방</th>
       <th>참가자ID</th>
       <th>참가자</th> 
       <th>참가여부</th>
       <th>참가일자</th>
      </tr>
   </thead>
   <tbody>
     <c:forEach items="${takeroom.content}"  var="takeroom" varStatus="st">
      <tr>
         <td>${takeroom.Takemembes.rnum}</td>
         <td><a href="view/${takeroom.num }">${takeroom.title }</a></td>
         <td>${takeroom.Takemembers.userid}</td>   
         <td>${takeroom.Takemembers.entrant}</td>
         <td>${takeroom.Takemembers.takeyn}</td> 
         <td><fmt:formatDate value="${takeroom.takemembers.regdate}" pattern="yyyy-MM-dd" /></td>            
      </tr>
     </c:forEach>
   </tbody>   
</table> 
 --%>

<!-- class = container -->
<script>
//추천여행 참가자 현황 리스트 principal.member.name
//var init = function(){
//	alert("테스트1")
//	$.ajax({
//		  type:"get",
//		  url:"/takemember/entryList/"+$("#num").val()
//		})
//		.done(function(resp) {
//				//alert(resp)
//				//console.log(resp);
//				var str ="<table class='table table-hove mt-3'>"
//				$.each(resp, function(key, val) {
//					str+="<tr>"
//					str += "<td>"+val.userid + "</td>"
//					str += "<td>"+val.entrant + "</td>"
//					str += "<td>"+val.regdate + "</td>"
//					if("${principal.member.userId}"==val.userid) {
//					  str += "<td><a href='javascript:fdel("+val.num+")'>삭제</a></td>"
//					}  
//					str+="</tr>"  
//				}) //each
//				str +="</table>"
//				$("#entryList").html(str);
//	})//done	
//} //init
var init = function(){
		$.ajax({
			  type:"get",
			  url:"/takecomment/commentList/"+$("#num").val()
//			  url:"/takecomment/commentList/${takeroom.num}"
			//  url:"/reply/commentList",
			//  data:{"bnum":$("#num").val()}
 		})
 		.done(function(resp) {
					//alert(resp)
					var str ="<table class='table table-hove mt-3'>"
					$.each(resp, function(key, val) {
						str+="<tr>"
						str += "<td>"+val.nickname + "</td>"
						str += "<td>"+val.content + "</td>"
						str += "<td>"+val.regdate + "</td>"
						if("${principal.member.userId}"==val.member.userId) {
						  str += "<td><a href='javascript:commentdel("+val.rnum+")'>삭제</a></td>"
						}  
						str+="</tr>"  
					}) //each
					str +="</table>"
					$("#replyResult").html(str);
		})//done
		
} //init
function commentdel(cnum) {
	$.ajax({
		   type : "delete",
		   url : "/takecomment/commentDelete/"+cnum
	}).done(function(resp) {
		   alert(resp + "번 댓글 삭제가 잘 되었습니다.")
		   init()
	}).fail(function(e) {
		   alert("댓글삭제가 잘 못되었습니다. :" + e)
	})
} //commentdel
//댓글추가
$("#btnComment").click(function() {
  		if("${empty principal.member.username}" ==""){
			alert("로그인 하세요");
			location.href="/login";
			return;
		} 
  		if ($("#msg").val() == "") {
  			alert("여행후기를 작성하세요")
  			   return;
  		}
		var data = {
			   "rnum": $("#num").val(),
			   "content": $("#msg").val()
		}
		$.ajax({ //takecommentInsert
			   type:"POST",
			   url:"/takecomment/takecommentInsert/"+$("#num").val(),
			   contentType:"application/json;charset=utf-8",
			   data:JSON.stringify(data)
		})
		.done(function(resp,status) {
//			   alert(status)
			   alert("댓글 작성이 잘 되었습니다.");
			   init()
		})
		.fail(function() {
			   alert("댓글 작성이 잘 못되엇습니다.:"+e)
		})
	})
//추천여행 클럽 참가자 탈퇴(삭제)
function fdel(rnum) {
	if("${empty principal.member.username}" ==""){
		alert("로그인 하세요");
		location.href="/login";
		return;
	} 
	$.ajax({
		   type : "delete",
		   url : "/takemember/delete/"+rnum
	}).done(function(resp) {
		   alert(resp + "추천여행 참여클럽 탈퇴처리가 되었습니다.")
		   init()
	}).fail(function(e) {
		   alert("여행참여 클럽처리가 잘 못 되었습니다. :" + e)
	})
} //fdel
//추천여행 참가하기 
$("#btnEntry").click(function() {
	if("${empty principal.member.username}" ==""){
		alert("로그인 하세요");
		location.href="/login";
		return;
	} 
	var data = {
		   "num": $("#num").val(),
		   "takeyn": "Y"
	}
	$.ajax({ //takeememberInsert
		   type:"POST",
		   url:"/takemember/entryInsert/"+$("#num").val(),
		   contentType:"application/json;charset=utf-8",
		   data:JSON.stringify(data)
	})
	.done(function(resp,status) {
//		   alert(status)
		   alert("추천여행 클럽에 참가가 잘 되었습니다.");
		   init()
	})
	.fail(function() {
		   alert("클럽에 참가하기가 실패하였습니다.:"+e)
	})
})
//참여여행 클럽삭제
$("#btnDelete").click(function() {
	if (!confirm("정말 삭제할까요?")) //false
		  return false;
	$.ajax({
		   type : "delete",
		   url : "/takeroom/delete/${takeroom.num}",
		   success : function(resp) {
		   if (resp == "success") {
			    	alert("참가여행 클럽이 삭제가 잘 되었습니다.")
				    location.href = "/takeroom/list";
			} //if
		},//success
		error : function(e) {
			    alert("삭제가 잘 못 되었습니다. : " + e)
		}
	}) //ajax
}) //btnDelete
//참여여행 클럽 상세보기 수정폼
$("#btnUpdate").click(function() {
	if(${empty principal.member.name}==""){
		alert("로그인 하세요");
		location.href="/login";
		return;
	}  
/* 		if($("#openyn").val()=="N"){
		 alert("추천여행 오픈방이 마감되어 수정작업을 할 수 없습니다.") 
		 $("#openyn").focus();
		 return false;
    } */
	if (!confirm("정말 수정할까요?"))
		   return false;
	 location.href = "/takeroom/update/${takeroom.num}" // JSP
})
  init();
</script>
</body>
</html>