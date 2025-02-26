<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>user3::register</title>
</head>
<body>
	<h3>user3 등록</h3>
	<a href="../3.jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>
	
	<form action="./proc/register.jsp" method="post">
		<input type= "text" name= "uid" placeholder="아이디 입력"> <br>
		<input type= "text" name= "name" placeholder="이름 입력"> <br>
		<input type= "text" name= "birth" placeholder="생년월일 입력"> <br>
		<input type= "text" name= "hp" placeholder="휴대폰 입력"> <br>
		<input type= "text" name= "addr" placeholder="주소 입력"> <br>
		<input type = submit value="등록하기">
	</form>
</body>
</html>