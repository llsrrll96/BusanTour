<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customLogin</title>
</head>
<body>

<!--SecurityConfig 에 /loginPro 으로 넘어가도록 정의-->
<form action="/loginPro" method="post"> 
	ID :       <input type="text"            name="username" /><br/>
	PWD :  <input type="password"  name="password"/><br/>
	<button>로그인</button>
</form>

</body>
</html>