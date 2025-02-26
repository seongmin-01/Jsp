<%@page import="entity.User"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//클라이언트 사용자객체 세션에서 가져오기 
	User user = (User)session.getAttribute("username");

	if(user == null) {
		//로그인을 안하고 해당 페이지를 요청할 경우 
		//인증이 필요한 페이지므로 로그인 없이 요청할 수 없도록 막아야 함. (해킹방지)
		response.sendRedirect("../session.jsp?code=102");
		return; // 처리 종료
	}
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginSuccess</title>
</head>
<body>
	<h3>로그인 성공</h3>
	
	<p>
		<%=user.getName() %>님 반갑습니다.
	</p>
	<a href="Logout.jsp">로그아웃</a>
	
	
</body>
</html>