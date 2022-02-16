<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="a.b.c.com.mem.vo.SpringMemberVO" %>
<%@page import="a.b.c.com.common.CodeUtil" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 전체조회</title>
<style type="text/css">
	*{
		margin: 0 auto;
		/*text-align: center;*/
	}
	
	td, th{
		padding: 5px;
	}
	
	.tt{
		text-align: center;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

		$(document).ready(function() {
			
			//mnumCheck 체크박스 체크확인하기
			$(document).on("click", "#mnum", function(){
				//alert("chkInSbnum >>> : ");
				if($(this).prop('checked')){
					//$('input[type="checkbox"][name="sbnum"]').prop('checked',false);
					$('.mnum').prop('checked',false);
					$(this).prop('checked',true);
				}
			});
			
			//I
			$(document).on("click","#I",function(){
				location.href="memForm.ldh";
			});
			
			//SALL
			$(document).on("click","#SALL", function(){
				$("#memSelectAllForm").attr({"method":"GET", "action":"memSelectAll.ldh"}).submit();
			});
			
			//U
			$(document).on("click","#U", function(){
				if($('.mnum:checked').length == 0){
					alert("수정할 글번호 하나를 선택하세요!!");
					return;
				}
				$("#memSelectAllForm").attr({"method":"GET","action":"memSelect.ldh"}).submit();
			});
			
			//D
			$(document).on("click","#D",function(){
				if($('.mnum:checked').length == 0){
					alert("삭제할 글번호 하나를 선택하세요!!");
					return;
				}
				$("#memSelectAllForm").attr({"method":"GET","action":"memSelect.ldh"}).submit();
			});
		});
</script>
</head>
<% request.setCharacterEncoding("EUC-KR"); %>
SELECT ALL
<%
	Object obj = request.getAttribute("listAll");
	if(obj == null) return;
	
	ArrayList<SpringMemberVO> aList = (ArrayList<SpringMemberVO>)obj;
	int nCnt = aList.size();
	out.println(":::: 전체조회 건수 " + nCnt +"건");
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<img src="/springLdh/img/img_mandu/ase.gif" width="25" height="25" alter="image">
	MEMBER TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="memSelectAllForm" id="memSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">순번</td>
	<td class="tt">회원번호</td>
	<td class="tt">이름</td>
	<td class="tt">아이디</td>
	<td class="tt">성별</td>
	<td class="tt">생년월일</td>
	<td class="tt">핸드폰</td>
	<td class="tt">이메일</td>
	<td class="tt">주소</td>
	<td class="tt">취미</td>
	<td class="tt">사진</td>	
	<td class="tt">수정일</td>
</tr>
</thead>
<%
	String gender = "";
	String birth = "";
	String hp = "";
	String tel = "";
	String email = "";
	String addr = "";
	String hobby = "";
	
	for(int i=0; i<nCnt; i++){
		SpringMemberVO mvo = aList.get(i);
		gender = CodeUtil.gender(mvo.getMgender());
		birth = CodeUtil.birth(mvo.getMbirth());
		hp = CodeUtil.hp(mvo.getMhp());
		addr = mvo.getMzonecode() + " " + mvo.getMroadaddress().replace("@", " ");
		hobby = CodeUtil.hobbys(mvo.getMhobby());
	
%>
<tbody>
<tr>
<td class="tt">
		<input type="checkbox" id="mnum" name="mnum" class="mnum" value=<%= mvo.getMnum() %> >
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= mvo.getMnum() %> </td>
	<td class="tt"><%= mvo.getMname() %> </td>
	<td class="tt"><%= mvo.getMid() %> </td>
	<td class="tt"><%= gender %> </td>	
	<td class="tt"><%= birth %> </td>
	<td class="tt"><%= hp %> </td>
	<td class="tt"><%= mvo.getMemail() %> </td>
	<td class="tt"><%= addr %></td>
	<td class="tt"><%= hobby %></td>
	<td class="tt"><img src="/springLdh/fileupload/member/<%= mvo.getMphoto() %> " border="1" width="25" height="25" alt="image"></td>	
	<td class="tt"><%= mvo.getUpdatedate() %> </td>			
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="20" align="right">				
		<input type="button" value="등록" id="I">
		<input type="button" value="조회" id="SALL">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>