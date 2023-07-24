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
<h1>도서목록</h1> 
<hr>
<table>
<tr>
<th>도서번호</th>
<th>도서명</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<td>${b.bookid }</td>
<td>${b.bookname }</td>
</tr>
</c:forEach>

</table>


</body>
</html>