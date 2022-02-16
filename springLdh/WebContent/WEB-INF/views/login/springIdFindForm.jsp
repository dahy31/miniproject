<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IDFIND</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#mcomfirm").click(function(){
			console.log("mcomfirm >>> : ");		
			alert("mcomfirm >>> : ");
			
			let url = "email_authentication.ldh";						
			let mnameVal = $("#mname").val();			
			let memailVal = $("#memail").val();			
						
			$.get(url
				 ,{ "mname":mnameVal, "memail":memailVal }			
				 ,function(data){	
					var sVal = $(data).find("result").text();	
					alert(sVal);					
				 }
			);
		});
		
		$("#idbtn").click(function(){
			console.log("idbtn >>> : ");
			alert("idbtn >>> : ");
			$('#idForm').attr({
				'action':'idFind.ldh',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
	});

</script>
</head>
<body>
<h3 align="center">IDFIND: 아이디 찾기</h3>
<h3 align="center">본인확인 이메일로 인증</h3>
<hr>
<%
	//Object obj = request.getAttribute("aList");
	//if(obj == null) return;
	String mname = "";
	String memail = "";
	String authnum = "";
	
	//if(obj != null){
	// ArrayList<String> aList = (ArrayList)obj;
	//System.out.println("aList.size() >>> : " + aList.size());
	//mname = aList.get(0);
	//memail = aList.get(1);
	//authnum = aList.get(2);
	//}
	System.out.println("idEmailCheck mname >>> : " + mname);
	System.out.println("idEmailCheck memail >>> : " + memail);
	System.out.println("idEmailCheck authnum >>> : " + authnum);
%>
<h4 align="center">본인확인 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</h4>
<form name="idForm" id="idForm">
<table border="1" align="center">
<tr>
<td>이름</td>
<td><input type="text" name="mname" id="mname" value='<%= mname%>' style="width:200px;"></td>
</tr>
<td>이메일</td>
<td><input type="text" name="memail" id="memail" value='<%= memail%>' placeholder="" style="width:200px;">
	<button type="button" id="mcomfirm">인증번호받기</button>
</td>
</tr>
<tr>
<td>인증번호</td>
<td>
<input type="text" name="authnum" id="authnum" value='<%= authnum%>'
		placeholder="인증번호 6자리 숫자 입력" style="width:200px;"></td>
</tr>
<tr>
<td></td>
<td>인증번호가 오지 않나요??
	<img src="/springLdh/img/img_mandu/ase.gif" width="20" height="20"
	title="발송한 메일이 스펨 메일로 분류되는 것은 아닌지  &#13;확인하세요, 스펨메일함에도 메일이 없으면, &#13;다시 한 번 '인증번호 받기'를 눌러주세요 ">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id="idbtn">다음</button>
</td>
</tr>
</table>
</form>
</body>
</html>
