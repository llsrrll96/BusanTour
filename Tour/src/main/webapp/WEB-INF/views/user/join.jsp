<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../includes/header.jsp" %>
    
<head>
<meta charset="UTF-8">

<title>Join</title>
</head>
<style>
	.bir_yy, .bir_mm, .bir_dd{
		width:160px;
		display:table-cell;
	}
	.bir_mm+.bir_dd, .bir_yy+ .bir_mm{
		padding-left:10px;
	}

</style>
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
									<label class="mb-2 text-muted" for="username">사용자명</label>
									<input id="name" type="text" class="form-control" name="name" value="" required autofocus>
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
									<div class="mb-2 w-100"
										<label class="text-muted" for="interfield">자기소개</label>
									</div>
									<input id="interfield" type="text" class="form-control" name="interfield" >
								</div>
								
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="address">주소 (사는 지역)</label>
									</div>
									<input id="address" type="text" class="form-control" name="address" >
								</div>
													
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="mm">생년월일</label>
									</div>
									<div class="bir_yy">
										<span class="ps_box">
											<input type="text" class="form-control" id="yy"  placeholder="년(4자)" maxlength="4">
										</span>
									</div>
									
									<div class="bir_mm">
										<span class="ps_box focus">
										  <select class="custom-select"  id="mm" id="inputGroupSelect01">
												<option>월</option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
												<option>9</option>
												<option>10</option>
												<option>11</option>
												<option>12</option>
											</select>
										</span>
									</div>
									<div class="bir_dd">
										<span class="ps_box">
											<input type="text" class="form-control" id="dd" placeholder="일" maxlength="2">
										</span>
									</div>
										
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
			alert("사용자명을 입력해주세요")
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
			"password": $("#password").val(),
			"gender": $("#gender").val(),
			"email":$("#email").val(),
			"intro":$("#interfield").val(),
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
					alert("이미 존재하는 사용자명입니다.")
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