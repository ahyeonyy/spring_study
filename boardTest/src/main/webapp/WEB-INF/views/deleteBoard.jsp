<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 삭제</title>
</head>
<body>
<h1>게시물 삭제</h1>
<hr>
<form action = "deleteBoard" method="post" enctype="multipart/form-data">
<input type="hidden" name = "no" value=${b.no }>
글제목 : <input type = "text" name = "title" value="${b.title }"><br>
작성자 : <input type = "text" name = "writer" value="${b.writer }"><br>
글암호 : <input type = "password" name = "pwd" value="${b.pwd }"><br>
글내용 : <br>
<textarea rows="10" cols="60" name = "content">${b.content }</textarea><br>
<img src = "upload/${b.fname }" width="100" height="100">
<input type = "hidden" name = "fname" value = "${b.fname }">
첨부파일 : <input type = "file" name = "uploadFile"><br>

<input type = "submit" value = "삭제">
<input type = "reset" value = "다시 입력">

</form>
</body>
</html>