<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deleteConfirm(bookid){
	if(confirm("정말로 삭제하시겠습니까 ? ")){
		location.href="deletebook?bookid="+bookid;
	}
}
</script>
</head>

<body>
<h1>도서 상세 정보 </h1>
<a href = "updatebook?bookid=${b.bookid }">수정</a>
<a href = "#" onclick="deleteConfirm(${b.bookid})">삭제</a>
<hr>
도서번호 : ${b.bookid } <br>
도서명 : ${b.bookname } <br>
출판사 : ${b.publisher } <br>
도서가격 : ${b.price } <br>
</body>
</html>