<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEMP PW</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		alert(">>> : ");
		
		$("#emailbtn").click(function(){
			alert("emailbtn >>> : ");
			
			let url = "id_email_authentication.ldh";
			let midVal = $("#mid").val();
			let memailVal = $("#memail").val();
			
			$.get(url
				 ,{"mid":midVal,"memail":memailVal}
				 ,function(data){
					 var sVal = $(data).find("result").text();
					 alert(sVal);
				 }
			);
		});
		
		$("#pwbtn").click(function(){
			console.log("pwbtn >>> : ");
			$('#pwForm').attr({
				'action':'pwCreateForm.ldh',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
		
	});
</script>
</head>
<body>
<h3 align="center">TEMPPW</h3>
<hr>
<form name="pwForm" id="pwForm">
<table border="1" align="center">
<tr>
<td>아이디</td>
<td><input type="text" name="mid" id="mid" style="width:200px;"></td>
</tr>
<td>이메일 주소</td>
<td>
	<input type="text" name="memail" id="memail" style="width:200px;">
	<button type="button" id="emailbtn">인증번호 받기</button>
</td>
<tr>
<td></td>
<td>인증번호가 오지 않나요???<img src="/springLdh/img/img_mandu/ase.gif" width="20" height="20"
title="발송한 메일이 스팸 메일로 분류되는 것은 아닌지 &#13;확인하세요, 스팸메일함에도 메일이 없으면, &#13;다시 한 번 '인증번호 받기'를 눌러주세요.">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id="pwbtn">다음</button>
</td>
</tr>
</table>
</form>
</body>
</html>