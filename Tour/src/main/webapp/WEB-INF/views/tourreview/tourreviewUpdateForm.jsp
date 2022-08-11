<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>여행 리뷰 업데이트</title>


</head>
<body>

<%@ include file="../includes/boardCategory.jsp" %>


<div class="container form">

	<div class="mt-3">
	  <h4>여행 리뷰 수정</h4>
	</div>
<hr>


    <div class="form-group row">
      <div class="btn-group col-sm  dropdown">
		  <button class="btn btn-secondary dropdown-toggle " type="button" id="area1" name="area1" data-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">
		  부산전체
		  </button>
		  <ul class="dropdown-menu dropdown" id="dropdown-menu" aria-labelledby="dropdownMenuClickable">
		    <c:forEach var="area1" items="${area1 }">
		    	<li ><a class="dropdown-item"  >${area1 }</a></li>
		    </c:forEach>
		  </ul>
		  
		</div>
		
		
      <input type="text" class="form-control col-sm" id="divide"
       placeholder="테마" name="divide" value=${reviewBoard.divide }>
    </div>
    
    
    <div class="form-group">
      <label for="title">제목</label>
<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
<!-- required 속성을 설정하면 필수입력 사항이된다. -->
<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
      <input type="text" class="form-control"  id="title"
       placeholder="제목 입력(4-100)"  name="title"
       maxlength="100" required="required" value="${reviewBoard.title }"
       pattern=".{4,100}">
    </div>
    
    <div class="form-group">
   <label for="contents">내용</label>
<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
   <textarea class="form-control" rows="5" id="contents"
    name="contents" placeholder="내용 작성">${reviewBoard.contents }</textarea>
 </div>

    <button id="btnUpdate" class="btn btn-success">수정</button>


</div>

<script>

//지역 드랍다운
$("#area1").text("부산전체"); //초기값
$("#dropdown-menu li > a").on('click',function(){
	$("#area1").text($(this).text());
})


//등록
// boardId 게시판고유번호 100
// num 자동생성
// userid : 세션의 사용자 이름값
// contentsId : 해당 게시글의 쿼리 스트링값
// hitcount, replycnt, regdate 자동생성
$("#btnUpdate").click(function(){
	if($("#divide").val()==""){
		alert("테마를 입력해주세요")
		return;
	}
	
	var data={
			"num":${reviewBoard.num},
			"title":$('input[name=title]').val(),
			"contents":$('textarea[name=contents]').val(),
			"area1":$("#area1").text(),
			"divide":$("#divide").val(),
	}
	console.log(data)
	$.ajax({
		type:"put",
		url:"/tourreview/update",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data),
		success:function(resp){
			if(resp=="success"){
				location.href="/tourreview/tourreviewView/${reviewBoard.num}" //상세보기로
			}else{
				alert("등록실패, 다시 확인해 주세요.")
					
			}
		}
		
	}) //ajax

})//click

</script>


</body>
</html>