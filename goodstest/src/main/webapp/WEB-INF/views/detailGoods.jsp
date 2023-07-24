<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
img{
width: 100px;
height: 100px;
}
</style>
<meta charset="UTF-8">
<title>상품상세보기</title>
<script type="text/javascript">
function confirmdelete(no) {
	if(confirm("정말로 삭제하시겠습니까?")){
		location.href = "deletegoods?no="+no;
	}
}
</script>
</head>
<body>
<h1>상품 상세 보기 </h1> 
<a href = "updategoods?no=${g.no }">수정</a>
<a href = "#" onclick="confirmdelete(${g.no})">삭제</a><hr>
상품번호 : ${g.no }<br>
상품명 : ${g.name }<br>
상품가격 :${g.price }<br>
상품수량 : ${g.qty }<br>
상품이미지 <br>
<img src="images/${g.fname }">
</body>
</html>