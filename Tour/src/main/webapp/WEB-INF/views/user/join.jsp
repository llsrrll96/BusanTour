<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../includes/header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
<div class="container">

<!-- 시간나면 고유닉네임 확인 절차 만들어야될듯 -->
	 <span>이름: </span> <input type="text"           id="name" name="name" /><br/>
	 <span>닉네임: </span> <input type="text"           id="nickname" name="nickname" /><br/>
	 <span>비밀번호: </span>  <input type="password"         id="password"  name="password" /><br/>
<!-- 	 비밀번호확인 -->
<!-- 	 성별 -->
	<span>성별: </span>
      <label><input type="radio" id="gender" name="gender" value="man" checked="checked"> 남</label>
      <label><input type="radio"  id="gender"  name="gender" value="girl">여</label><br/>
	 <span>이메일: </span>  <input type="email"       id="email"     name="email" /><br/>
	 <span>연락처: </span>  <input type="tel"       id="phone"     name="phone" /><br/>
	 <span>관심분야 한줄: </span>  <input type="text"       id="interfield"     name="interfield" /><br/>
	 <span>주소(사는 지역): </span>  <input type="text"       id="address"     name="address" /><br/>
	 
	 
	 
	 <button class="byn byn-second" id="btnJoin">회원가입</button>
	 
</div>
</body>

<script>
	$("#btnJoin").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력해주세요")
			return;
		}
		if($("#nickname").val()==""){
			alert("닉네임을 입력해주세요")
			return;
		}
		if($("#password").val()==""	){
			alert("비밀번호를 입력해주세요")
			return;
		}
		if($("#email").val()==""){
			alert("이메일을 입력해주세요")
			return;
		}
		if($("#interfield").val()==""){
			alert("관심분야 한줄 깔끔하게 적어주세요")
			return;
		}
		
		
		
		var data={
			"name": $("#name").val(),
			"nickName": $("#nickname").val(),
			"password": $("#password").val(),
			"gender": $("#gender").val(),
			"email":$("#email").val(),
			"phone":$("#phone").val(),
			"interField":$("#interfield").val(),
			"address":$("#address").val(),
			"email":$("#email").val()
		}
		
		$.ajax({
			type:"post",
			url:"/register",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(data),
			success:function(resp){
				if(resp=="success"){
					alert("성공")
					location.href="/login"
				}
				if(resp=="fail"){
					alert("이미 존재하는 이름입니다.")
					$("#name").focus();
					$("#name").val("");
				}
				
			},error:function(e){
				alert("실패: "+e)
			}
			
		})
		
	})
</script>

</html>