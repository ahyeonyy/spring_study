<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script>  
  	function deleteconfirm(bookid){
  		if(confirm("정말로 삭제하시겠습니까 ?")){
  			window.location.href = "deleteBook?bookid="+bookid;
  		}
  	}
  </script>
</head>
<body>
<h1>도서상세정보</h1> 
<a href = "updatebook?bookid=${b.bookid }">수정</a> 
<a href="#" 
onclick="deleteconfirm(${b.bookid})">삭제</a> 
<a href="listbook"> 전체목록 </a>
<hr>
<table class="table table-hover">
<tr>
<th>도서번호</th>
<th>도서명</th>
<th>출판사</th>
<th>도서가격</th>
</tr>
<tr>
<td>${b.bookid }</td>
<td>${b.bookname }</td>
<td>${b.publisher }</td>
<td>${b.price }</td>
</tr>
</table>
</body>
</html>