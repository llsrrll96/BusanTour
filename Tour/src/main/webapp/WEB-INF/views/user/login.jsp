<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../includes/header.jsp" %>
    

<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<c:if test="${not empty errorMsg }">
${errorMsg }
<script>
alert(${errorMsg});
</script>
</c:if>

<form action="/login" method="post"> 
	이름 :       <input type="text"            name="username" /><br/>
	비밀번호 :  <input type="password"  name="password"/><br/>
	<button>로그인</button>
</form>

</body>
</html>