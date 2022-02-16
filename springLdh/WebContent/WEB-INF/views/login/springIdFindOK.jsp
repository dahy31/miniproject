<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="a.b.c.com.mem.vo.SpringMemberVO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IDFIND OK</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#login").click(function(){
			console.log("login >>> : ");
			$('#idfindokForm').attr({
				'action':'loginForm.ldh',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
		
		$("#pwFine").click(function(){
			console.log("pwFine >>> : ");
			$('#idfindokForm').attr({
				'action':'loginForm.ldh',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();
		});
	});

</script>
</head>
<%
	Object obj = request.getAttribute("listIdFind");
	if(obj == null) return;
	
	ArrayList<SpringMemberVO> aList = (ArrayList<SpringMemberVO>)obj;
	SpringMemberVO lvo = aList.get(0);
	String mid = lvo.getMid();
	String insertdate = lvo.getInsertdate();
	
	System.out.println("idEmailCheck mid >>> : " + mid);
	System.out.println("idEmailCheck insertdate >>> : " + insertdate);
%>
<body>
<h3 align="center">IDFIND OK</h3>
<hr>
<form name="idfindokForm" id="idfindokForm">
<h4 align="center">회원님의 정보와 일치하는 아이디 목록입니다.</h4>
<table border="1" align="center">
<tr>
<td>
<input type="radio" name="mid" id="mid"><%= mid %>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
최초가입일: <%= insertdate %>
</td>
</tr>
<tr>
<td align="center">
<button id="login" style="background-color: yellow;">로그인하기</button>
<button id="pwFine">비밀번호 찾기</button>
</td>
</tr>
</table>
</form>
</body>
</html>