<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<hr>
<table>
<tr>
<th>아이디</th>
<th>이름</th>
</tr>
<c:forEach var=	"m" items="${list }">
<tr>
<td>${m.id }</td>
<td>${m.name }</td>
</tr>
</c:forEach>
</table>
</body>
</html>