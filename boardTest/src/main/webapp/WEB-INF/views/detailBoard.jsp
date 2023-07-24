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

글제목 : ${b.title }<br>
작성자 : ${b.writer }<br>
조회수 : ${b.hit }
 등록일 : ${b.regdate }<br>
글내용 : <br>
<textarea rows="10" cols="60" name = "content">${b.content }</textarea><br>
첨부파일 : <br>
<img src="upload/${b.fname }">

<a href="listboard">목록</a>
<a href="insertBoard?no=${b.no }">답글 작성</a>
<a href="updateBoard?no=${b.no }">수정</a>
<a href="deleteBoard?no=${b.no }">삭제</a>
</body>
</html>