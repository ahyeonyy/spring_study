<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
</head>
<body>
<h1>게시물 등록</h1>
<hr>
<form action = "insertBoard" method="post" enctype="multipart/form-data">
<input type="hidden" name = "no" value = "${no }">
글제목 : <input type = "text" name = "title"><br>
작성자 : <input type = "text" name = "writer" value="${id }"><br>
글암호 : <input type = "password" name = "pwd"><br>
글내용 : <br>
<textarea rows="10" cols="60" name = "content"></textarea><br>
첨부파일 : <input type = "file" name = "uploadFile"><br>
<input type = "submit" value = "등록">
<input type = "reset" value = "다시 입력">

</form>
</body>
</html>