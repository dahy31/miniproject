<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMAIL CHECK</title>
</head>
<body>
EMAIL CHECK
<hr>
<%
	//Object obj = request.getAttribute("authentication_num");
	//if (obj == null) return;
	//String authnum = obj.toString();
	
	String authnumStr = "메일을 확인하시고 인증번호를 입력하시오 ~!~!";
	System.out.println("emailCheck >>> : " + authnumStr);
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= authnumStr %></result>
	</login>
</body>
</html>