<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신처리
	String uid = request.getParameter("uid"); //getter이므로 반환값이 있음
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String addr = request.getParameter("addr");
	String[] hobbys = request.getParameterValues("hobby"); //중복선택 가능하므로 배열로 처리
%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>result2</title>
</head>
<body>
	
	<p>
		아이디 : <%= uid %> <br>
		비밀번호 : <%= pwd %> <br>
		이름 : <%= name %> <br>
		생년월일 : <%= birth %> <br>
		성별 : <%= gender %> <br>
		주소 : <%= addr %> <br>
		취미 : 
		<%
			for(String hobby : hobbys) {
				out.print(hobby + ", ");
			}
		%> <br>
		
	</p>
	
	<a href="../1.request.jsp">뒤로가기</a>
	
</body>
</html>