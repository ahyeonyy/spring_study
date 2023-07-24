<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정말 자고 싶 어 요 너무 졸 려 요 !</title>
<style type="text/css">
#goodsDetail {
	display: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
	$(function() {
		var goodsList;
		var deptList;
		$(document).on("click", ".goods", function() {
			// 눌러진 .goods에 속성 idx를 가져옴
			var idx = $(this).attr("idx");

			// 상세보기 할 상품 한 개를 배열로부터 가져옴 
			var g = goodsList[idx];
			$("#span_no").html(g.no);
			$("#span_name").html(g.name);
			$("#span_price").html(g.price);
			$("#span_qty").html(g.qty);
			$("#span_fname").html(g.fname);
			$("#goodsDetail").css("display", "block");

		})
		
		$(document).on("click",".dept")

		$.ajax({
			url : "listGoods",
			success : function(arr) {
				goodsList = arr;
				$.each(arr, function(i) {
					var li = $("<li></li>").html(this.name).addClass("goods");
					$(li).attr("idx", i)
					$("#goodsList").append(li);
				})

			}
		})
		$.ajax({
			url : "listDept",
			success : function(arr) {
				deptList = arr;
				$.each(arr, function(i) {
					var tr = $("<tr></tr>")
					var td1 = $("<td></td>").html(this.dno)
					var td2= $("<td></td>").html(this.dname)
					var td3 = $("<td></td>").html(this.dloc)
					$(tr).append(td1)
					$(tr).append(td2)
					$(tr).append(td3)
					$("#deptList").append(tr);
				})

			}
		})
	})
</script>
</head>
<body>
	<h2>부서목록</h2>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>부서위치</th>
			</tr>
		</thead>
		<tbody id = "deptList"></tbody>
	</table>


	<h2>상품목록</h2>
	<ul id="goodsList">
	</ul>
	<hr>
	<div id="goodsDetail">
		상품번호 : <span id="span_no"></span><br> 상품이름 : <span id="span_name"></span><br>
		상품가격 : <span id="span_price"></span><br> 상품수량 : <span
			id="span_qty"></span><br> 상품파일 : <span id="span_fname"></span><br>

	</div>
</body>
</html>













