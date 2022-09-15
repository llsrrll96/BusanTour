<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/manageHeader.jsp" %>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../resources/css/manageAPI_css.css"/>
	
	<title>API</title>
</head>
<body>

<div class="root bg-light bg-gradient">
	<div class="apicontent container bg-white  mr-2">
	
		<p class="fs-2">API </p>
		<hr/>

	
	<!-- 	탭 -->
	
		<div class="tab_body bg-white">
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">부산관광지</li> 
			    <li class="tab-link" data-tab="tab-2">tab2</li>
			    <li class="tab-link" data-tab="tab-3">tab3</li>
			</ul>
			
		<!-- 	관련 탭 내용 -->
			  <div id="tab-1" class="tab-content current">
				<!-- 		  	각종 기능 버튼 -->
			  	<div class="attraction-function-buttons">
			  				<!-- 		  	기능에 대한 바디 -->
					<div class="attraction-form">
				    	<input type="text"  id="pageNo"  value="1" placeholder="페이지 번호"/>
				    	<input type="text"  id="numOfRows"  value="10" placeholder="패이지당 갯수"  />
				  		<button class="request-attraction btn btn-light" id="request-attraction">부산명소정보 서비스 요청</button>
					
					</div>
			  	</div>
			  	<hr/>
		  		<button class="btn btn-light" id="cancel-table">태이블 초기화</button>
		  		<button class="btn" id="save-table">테이블 저장</button>
			  	
				
			  	<div class="attraction-content">
			  		<table class="table table-hover table-bordered" id="table">
			  		   <thead>
		  				 <tr>
					        <th>콘텐츠 ID</th>
					        <th>콘텐츠 명</th>
					        <th>구군</th>
					        <th>위도</th>
					        <th>경도</th>
					        <th>여행지</th>
					        <th>주소</th>
					        <th>이미지 URL</th>
					        <th>썸네일 URL</th>
					    </tr>
						</thead>
			  			<tbody id="attraction-body">
			  			
			  			</tbody>
					</table>
			  	</div>
			  	
			  	
			  </div>
			  <div id="tab-2" class="tab-content">tab content2</div>
			  <div id="tab-3" class="tab-content">tab content3</div>
		  </div>	

	</div>
</div>

<script>
$(document).ready(function(){
	  
	  $('ul.tabs li').click(function(){
	    var tab_id = $(this).attr('data-tab');

	    $('ul.tabs li').removeClass('current');
	    $('.tab-content').removeClass('current');

	    $(this).addClass('current');
	    $("#"+tab_id).addClass('current');
	  })
})

// 부산명소정보 api 요청
$("#request-attraction").click(function(){
	alert("요청 시작")
		var data={
		"pageNo" : $("#pageNo").val(),
		"numOfRows": $("#numOfRows").val()
	}
	$.ajax({
		type:"post",
		url:"/manage/api/attraction",
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data),
		success:function(resp){
			console.log(resp);
			if(resp.status===102) {
				alert("Error: "+resp.code);
				return;
			}
			for(var i = 0; i< resp.data.length; i++)
			{
				var attr= resp.data[i];
				var vr = '';
				
				vr += '<tr>';
				vr += '<td>' + attr.ucSeq+'</td>';
				vr += '<td>' + attr.mainTitle+'</td>';
				vr += '<td>' + attr.gugunName+'</td>';
				vr += '<td>' + attr.lat+'</td>';
				vr += '<td>' + attr.lng+'</td>';
				vr += '<td>' + attr.place+'</td>';
				vr += '<td>' + attr.addr1+'</td>';
				vr += '<td>' + attr.mainImageNormal+'</td>';
				vr += '<td>' + attr.mainImageThumb+'</td>';
				vr += '</tr>'
				
				$("#attraction-body").append(vr);
			}

		},
		error: function(jqXHR, textStatus, errorThrown){
			alert("Error: "+ textStatus+" : "+errorThrown)
		}
	}) //ajax
})

/* 테이블 비우기 */
$(function(){
	$('#cancel-table').click(function(){
		alert('전체 내용을 지웁니다.')
		$('#table > tbody').empty();
	});
});



	
// $("#request-attraction").click(function(){
// 	alert("요청 시작")

// 	if($("#pageNo").val()==""){
// 		alert("페이지 번호를 입력해주세요")
// 		return;
// 	}
// 	if($("#numOfRows").val()==""){
// 		alert("패이지당 갯수를 입력해주세요")
// 		return;
// 	}
	
// 	var data={
// 		"pageNo" : $("#pageNo").val(),
// 		"numOfRows": $("#numOfRows").val()
// 	}

// 	$.ajax({
// 		type:"post",
// 		url:"/manage/busanThema",
// 		contentType:"application/json;charset=utf-8",
// 		data:JSON.stringify(data),
// 		success:function(resp){
// 			console.log(resp)
// 			if (resp.status == "OK") alert(resp.data+" 개 "+resp.message)
// 			else alert(resp.message)

// 		},
// 		error: function(jqXHR, textStatus, errorThrown){
// 			alert("Error: "+ textStatus+" : "+errorThrown)
// 		}
// 	}) //ajax
// })

</script>


</body>
</html>