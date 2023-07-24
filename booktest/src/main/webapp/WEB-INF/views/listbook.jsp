<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>도서목록</h1>
<hr>
<table class="table table-hover">
<tr>
<th>도서번호</th>
<th>도서명</th>

</tr>
<c:forEach var="b" items="${list }">
<tr>
<td>${b.bookid }</td>
<td><a href = "detailBook?bookid=${b.bookid }">${b.bookname }</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>