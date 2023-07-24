<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<table>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>가격</td>
			<td>Action</td>
		</tr>   
		<tr>
			<c:forEach var="g" items="${list }">
				<td>${g.no }</td>
				<td>><a href="">${g.name }</a></td>
				<td>${g.price }</td>
				<td>Action</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>