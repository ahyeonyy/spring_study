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
<h1>상품목록</h1>
<hr>
<table>
<tr>
<th>상품번호</th>
<th>상품명</th>
</tr>
<c:forEach var="g" items="${list }">
<tr>
<td>${g.no }</td>
<td>${g.name }</td>
</tr>
</c:forEach>
</table>
</body>
</html>