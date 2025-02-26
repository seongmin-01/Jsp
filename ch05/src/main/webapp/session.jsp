<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>session</title>
	<!-- 
		날짜 : 2025/02/05
		이름 : 김성민
		내용 : JSP 세션 실습
	 -->
</head>
<body>
	<h3>2.세션</h3>
	
	<h4>세션 로그인 실습</h4>
	<form action="./proc2/LoginSession.jsp" method="post">
		<input type="text" name="uid" placeholder="아이디 입력"> <br>
		<input type="password" name="pwd" placeholder="비밀번호 입력"> <br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>