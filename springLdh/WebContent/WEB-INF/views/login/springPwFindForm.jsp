<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PWFIND_ID</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#mid").attr('placeholder','아이디');
		
		$("#pwIdFindbtn").click(function(){
			console.log("pwFindbtn >>> : ");
			
			$('#pwIdFindForm').attr({
				'action':'pwIdFind.ldh',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
	});
</script>
</head>
<body>
<h3 align="center">PWFIND_ID</h3>
<hr>
<h4 align="center">비밀번호를 찾고자 하는 아이디를 입력해 주세요</h4>
<form name="pwIdFindForm" id="pwIdFindForm">
<table border="1" align="center">
<tr>
<td><input type="text" name="mid" id="mid" style="width:200px;"></td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id="pwIdFindbtn">다음</button>
</td>
</tr>
</table>
</form>
</body>
</html>