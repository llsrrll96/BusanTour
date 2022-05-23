<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../includes/header.jsp" %>
    
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>

<div class="container">

 	<section class="h-100 mt-5">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">

					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">회원 가입</h1>
							
								<div class="mb-3">
									<label class="mb-2 text-muted" for="username">이름</label>
									<input id="name" type="text" class="form-control" name="name" value="" required autofocus>
								</div>

								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="nickname">닉네임</label>
									</div>
									<input id="nickname" type="password" class="form-control" name="nickname" required>
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Password</label>
									</div>
									<input id="password" type="password" class="form-control" name="password" required>
								</div>
								
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="gender">성별</label>
									</div>
							      <label>남  <input type="radio" id="gender" name="gender" value="man" checked="checked" > </label>
							      <label>여  <input type="radio"  id="gender"  name="gender" value="girl"></label><br/>
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="email">이메일</label>
									</div>
									<input id="email" type="email" class="form-control" name="email" >
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="email">연락처</label>
									</div>
									<input id="email" type="email" class="form-control" name="email" >
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100"
										<label class="text-muted" for="phone">관심분야 한 줄</label>
									</div>
									<input id="phone" type="text" class="form-control" name="phone" >
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="address">주소 (사는 지역)</label>
									</div>
									<input id="address" type="text" class="form-control" name="address" >
								</div>
								
								
<!-- 								버튼 -->
								<div class="d-flex align-items-center">
									<button class="byn btn-secondary" id="btnJoin">
										회원 가입
									</button>
								</div>
								
						</div>

					</div>
					<div class="text-center mt-5 text-muted">
						Copyright &copy; 2022 &mdash; 함께해요 부산여행
					</div>
				</div>
			</div>
		</div>
	</section>
	 
	 
	 
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