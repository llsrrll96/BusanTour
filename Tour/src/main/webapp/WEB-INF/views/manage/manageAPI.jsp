<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>API</title>
</head>
<body>
<div class="container">
	<h3 class="mt-5 mb-5">부산테마여행정보 API </h3>
	<div class="request-form">
    	<input type="text"  id="pageNo" placeholder="페이지 번호"/>
    	<input type="text"  id="numOfRows"  value="10"placeholder="패이지당 갯수 (10 권장)"  />
    	<button id="requestAPI"  class="btn btn-light" >요청하기</button>
	</div>
</div>

<script>


$("#requestAPI").click(function(){
	if($("#pageNo").val()==""){
		alert("페이지 번호를 입력해주세요")
		return;
	}
	if($("#numOfRows").val()==""){
		alert("패이지당 갯수를 입력해주세요")
		return;
	}
	
	var data={
		"pageNo" : $("#pageNo").val(),
		"numOfRows": $("#numOfRows").val()
	}

	$.ajax({
		type:"post",
		url:"/manage/busanThema",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data),
		success:function(resp){
			console.log(resp)
			if (resp.status == "OK") alert(resp.data+" 개 "+resp.message)
			else alert(resp.message)

		},
		error: function(jqXHR, textStatus, errorThrown){
			alert("Error: "+ textStatus+" : "+errorThrown)
		}
	}) //ajax
})

</script>


</body>
</html>