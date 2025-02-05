<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>createCookie</title>
</head>
<body>
	<h3>쿠키생성</h3>
	<%
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		// 프로젝트 컨텍스트 경로 구하기
		String ctxPath = application.getContextPath();
		
		//아이디가 abc, 비밀번호가 1234로 간주
		if(uid.equals("abc") && pwd.equals("1234") ) {
			
			// 쿠키생성
			Cookie cookie = new Cookie("username", uid);
			cookie.setMaxAge(60 * 3); //쿠키의 수명  초 * 분 * 시간 -> 3분
			cookie.setPath(ctxPath); //쿠킥의 유효범위 지정
			
			// 응답객체로 클라이언트에게 쿠키전송
			response.addCookie(cookie);
			
			//성공페이지 이동
			response.sendRedirect("./successLogin.jsp");
		}
		else {
			//실패페이지 이동
			response.sendRedirect("./failLogin.jsp");
		}
	%>
</body>
</html>