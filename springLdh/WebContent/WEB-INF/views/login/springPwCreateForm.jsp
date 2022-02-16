<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW CREATE FORM</title>
</head>
<body>
<h3>PW CREATE FORM</h3>
<hr>
<form name="pwCreateForm" id="pwCreateForm">
<table border="1">
<tr>
<td>임시비밀번호</td>
<td><input type="text" name="ptemppw" id="ptemppw" style="width:200px;"></td>
</tr>
<tr>
<td>새비밀번호</td>
<td><input type="text" name="mpw" id="mpw" style="width:200px;"></td>
</tr>
<tr>
<td>새비밀번화 확인</td>
<td><input type="text" name="mpw_r" id="mpw_r" style="width:200px;"></td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id="btn" style="background-color:yellow;">다음</button>
</td>
</tr>
</table>
</form>
</body>
</html>