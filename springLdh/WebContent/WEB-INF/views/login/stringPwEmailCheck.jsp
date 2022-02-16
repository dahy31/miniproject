<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW EMAIL CHECK</title>
</head>
<body>
PW EMAIL CHECK
<hr>
<%
	Object obj = request.getAttribute("temp_pw_num");
	if(obj == null) return;
	
	String temp_pw_num = obj.toString();
	String ptemppwStr = "메일을 확인 하시고 임시 비밀번호로 새로운 비밀번호를 만드시오 ~!!";
	System.out.println("ptemppwStr >>> : " + ptemppwStr);
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= ptemppwStr %></result>
</body>
</html>