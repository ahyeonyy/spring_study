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
<h1>목록</h1>
<hr>
<a href = "insertBoard">새 글 작성</a>
<table>
<tr>
<th>게시물 번호</th>
<th>제목</th>
<th>작성자</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<td>${b.no }</td>

<td><a href="detailBoard?no=${b.no }">
<c:if test="${b.b_level > 0 }">
<c:forEach begin="1" end = "${b.b_level }">&nbsp;&nbsp;</c:forEach>
==>
</c:if>${b.title }</a></td>
<td>${b.writer }</td>
</tr>
</c:forEach>
</table>
<hr>
<c:forEach var="i" begin="1" end="${totalPage }">
<a href="listboard?pageNUM=${i }">${i } </a>&nbsp;
</c:forEach>
</body>
</html>
















