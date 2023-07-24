<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>도서 등록</h1>
<hr>
<form action="insertbook" method = "post">
도서번호 : <input type="text" name = "bookid" autofocus="autofocus"><br>
도서명 : <input type="text" name = "bookname" ><br>
출판사명 : <input type="text" name = "publisher" ><br>
도서가격 : <input type="text" name = "price" ><br>
<input type = "submit" value="등록"><input type = "reset" value="취소">
</form>
</body>
</html>