<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<hr>
<form action="/login" method = "post">
<input type = "hidden" name = "${_csrf.parameterName }" value="${_csrf.token }"/>
아이디:<input type="text" name = "username"><br>
비밀번호:<input type="password" name = "password"><br>
<button>로그인</button>

</form>
</body>
</html>