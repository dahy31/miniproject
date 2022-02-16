<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="a.b.c.com.mem.vo.SpringMemberVO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style type="text/css">
	div,h3 {
		text-align: center;
	}
	/*a 태그 밑줄 없애기*/
	a { text-decoration:none }
</style>
<script type="text/javascript">

</script>
</head>
<body>
<h3>Login Session Testing :: LOGIN SUCCESS</h3>
<hr>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Object obj = request.getAttribute("listLogin");
	if(obj == null) return;
	
	List<SpringMemberVO> list = (List<SpringMemberVO>)obj;
	int nCnt = list.size();
	
	if(nCnt == 1){
		String mid = list.get(0).getMid();
%>

	<script>
		alert("<%= mid %> 님 로그인 성공");
	</script>
	<div>
		<a href="springLogout?mid=<%= mid %>" >로그아웃 하기</a>
	</div>
<%
	}
%>
</body>
</html>