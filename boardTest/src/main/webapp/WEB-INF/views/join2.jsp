<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box_check,#box_phone,#box_email{
	display:none;
}
#box_reg{
display:none;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function(){
	
	var sendNUM;
	var userNUM;
	
	var email;
	var phone;
	
	var to;
	
	var aythType;
	
	$("#radio_phone").click(function(){
		$("#span_auth").html("휴대폰 번호 :")
		authType = "phone";
	});
	$("#radio_email").click(function(){
		$("#span_auth").html("이메일 :")
		authType = "email";
	});
	
	$("#btnCheck").click(function(){
		to = $("#to").val()
		var data  = {
			authType:authType,to:to
		};
		
		$.ajax({
			url:"validCheck",
			data:data,
			success:function(n){
				sendNUM = eval(n);
				$("#box_send").css("display","none");
				$("#box_check").css("display","block");
				
				if(authType == "phone"){
				$("#db_phone").val(to)					
				}else{
				$("#db_email").val(to)					
				}
			}
		})
	});
	
	$("#btnCheckNUM").click(function(){
		var userNUM = eval(  $("#checkNUM").val()  );
		if(userNUM == sendNUM){
			alert("인증되었습니다.")
			$("#box_reg").css("display","block")
		}else{
			alert("인증에 실패했습니다.")
		}
	})
})
</script>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	
	<div id="box_send">
	<input type="radio" id = "radio_phone" name ="auth">문자 인증
	<input type="radio" id = "radio_email" name="auth">이메일 인증
	
	<span id="span_auth">전화번호</span> : 
	<input type="text" id="to" autofocus="autofocus">
	<button id="btnCheck">인증</button>
	</div>
	
	<div id="box_check">
	인증번호 입력 : <input type="text" id = "checkNUM">
	<button id="btnCheckNUM">확인</button>
	</div>
	<div id = "box_reg">
	<form action = "insertMember" method="post">
	아이디 : <input type="text" name = "id" autofocus="autofocus"><br>
	암호 : <input type="password" name = "pwd"><br>
	이름 : <input type="text" name ="name"><br>
	이메일 : <input type="email" name = "email" id="db_email"><br>
	전화번호  : <input type="tel" name = "phone" id="db_phone"><br>
	<input type="submit" value="가입">
	</form>
	</div>
</body>
</html>












