<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/boardHeader.jsp" %>

<head>
<meta charset="UTF-8">
<title>멤버 관리</title>
</head>
<body>


	<div class="container member-table">
		<div class="div_link mt-1">
			<a href="/manage/manageHome" class="link" style = "color: rgb(0, 0, 150);">관리 홈</a>
		</div>
		<h3 class="fs-1 mt-5 mb-5">멤버 관리 ${count }</h3>
	
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">닉네임</th>
			      <th scope="col">이메일</th>
			      <th scope="col">성별</th>
			      <th scope="col">가입일</th>
			      <th scope="col">역할</th>
			      <th scope="col">탈퇴여부</th>
			      <th scope="col">탈퇴</th>
			    </tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="member" items="${memberList }">
			  			<tr>
			  				<th scope="row">${member.name }</th>
			  				<td>${member.nick_name }</td>
			  				<td>${member.email }</td>
			  				<td>${member.gender }</td>
			  				<td>${member.regdate }</td>
			  				<td>${member.role }  
			  				<!-- Role -->
								<div class="btn-group">
								  <button type="button" class="btn btn-warning dropdown-toggle btn-sm" data-toggle="dropdown" aria-expanded="false">
								    Role 부여
								  </button>
								  <ul class="dropdown-menu" id="dropdown-menu">
								    <li><a class="dropdown-item"  href="javascript:update('${member.name}', 'USER_ROLE');">USER_ROLE</a></li>
								    <li><a class="dropdown-item" href="javascript:update('${member.name}', 'ADMIN_ROLE');" >ADMIN_ROLE</a></li>
								  </ul>
								</div>
			  				</td>
			  				<c:if test="${member.withdraw eq '0'}">
			  				<td>정상</td>
			  				</c:if>
			  				<c:if test="${member.withdraw eq '1'}">
			  				<td>탈퇴</td>
			  				</c:if>
			  				
			  				<c:if test="${member.withdraw eq '0'}">
			  				<td><a href="javascript:withdraw('${member.name}');" >강제탈퇴</a></td>
			  				</c:if>
			  				<c:if test="${member.withdraw eq '1'}">
			  				<td>탈퇴 처리 완료</td>
			  				</c:if>
			  				
			  			</tr>
			  		</c:forEach>
			  </tbody>
			</table>
	</div>
	
	
<script>

function update(name, role)
{	
	var data={
			"name":name,
			"role":role
	}
	
	$.ajax({
		type:"put",
		url:"/manage/updateMemberRole",
		contentType:"application/json;charset=utf-8",
		data :JSON.stringify(data),
		success:function(resp){
			alert("권한 변경 완료")
			location.href="/manage/manageMember"
		},
		error:function(e){
			alert("실패: "+e)
			
		}
	}) // ajax
	return;
}


function withdraw(name)
{

	if(confirm("탈퇴처리를 하시겠습니까?\n주의: 복구 불가!") == true)
	{
	
		$.ajax({
			type:"put",
			url:"/manage/updateMemberWithdraw/"+name,
	
			success:function(resp){
				alert("탈퇴 처리 완료")
				location.href="/manage/manageMember"
			},
			error:function(e){
				alert("실패: "+e)
				
			}
		}) // ajax
	}
	return;
}






</script>
	
	
	
</body>
</html>