<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
	$(function() {
		$("#keyfield").click(function() {
			var selected = $(this).val();
			if (selected === "price") {
				$("#op").css("display", "inline");
			} else {
				$("#op").css("display", "none");
			}
		})
	})
</script>
<style>
#op {
	display: none;
}
</style>
</head>
<body>
	<h1>도서목록</h1>
	<form action="listbook" method="post">
		<select name=keyfield id="keyfield">
			<option value="bookname">도서명</option>
			<option value="publisher">출판사</option>
			<option value="price">가격</option>
		</select> 
		<select name="op" id="op">
			<option value=">">></option>
			<option value=">=">></option>
			<option value="<"><</option>
			<option value="<="><=</option>
			<option value="=">=</option>
		</select> : <input type="search" name="keyword"> <input type="submit"
			value="검색">
	</form>
	<table class="table table-striped">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid}</td>
				<td><a href="detailbook?bookid=${b.bookid }">${b.bookname}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>