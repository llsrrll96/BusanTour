<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../includes/header.jsp" %>
    

<head>
    <link href="loginStyle.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>로그인</title>
</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

<c:if test="${not empty errorMsg }">
${errorMsg }
<script>
alert(${errorMsg});
</script>
</c:if>

<form action="/login" method="post" autocomplete="off"> 


	<section class="h-100 mt-5">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
<!-- 					<div class="text-center my-5"> -->
<!-- 						<img src="https://getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg" alt="logo" width="100"> -->
<!-- 					</div> -->
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
								<div class="mb-3">
									<label class="mb-2 text-muted" for="username">사용자명</label>
									<input id="username" type="text" class="form-control" name="username" value="" required autofocus>
									
								</div>

								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Password</label>

									</div>
									<input id="password" type="password" class="form-control" name="password" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<div class="d-flex align-items-center">
									
									<button class="btn btn-primary ms-auto">
										Login
									</button>
								</div>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								Don't have an account? <a href="/join" class="text-dark">Create One</a>
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

</form>

</body>
</html>