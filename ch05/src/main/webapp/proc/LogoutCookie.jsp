<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//클라이언트 쿠키 삭제
	Cookie cookie = new Cookie("username", null);
	cookie.setMaxAge(0); //쿠키의 수명을 0으로 -> 이게 핵심임
	response.addCookie(cookie);
	response.sendRedirect("../cookie.jsp?code=101");

%>