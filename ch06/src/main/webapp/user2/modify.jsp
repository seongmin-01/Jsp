<%@page import="entity.User2"%>
<%@page import="entity.User1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	
	//데이터베이스 처리
	String host = "jdbc:mysql://localhost:3306/studydb";
	String user = "root";
	String pwd = "1234";

	User2 user2 = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pwd);
		
		String sql = "select * from `user2` where `uid`= ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,uid);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()) {
			user2 = new User2();
			user2.setUid(rs.getString(1));
			user2.setName(rs.getString(2));
			user2.setBirth(rs.getString(3));
			user2.setAddr(rs.getString(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}

%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>user2::modify</title>
</head>
<body>
	<h3>user2 수정</h3>
	<a href="../2.jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>
	
	<form action="./proc/modify.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<!-- readonly - 데이터입력을 막기 위해 사용 (id는 수정못하게 하기 위함) -->
				<td><input type="text" name="uid" value="<%= user2.getUid() %>" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= user2.getName() %>"></td>
			</tr>
			
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" value="<%= user2.getBirth() %>"></td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="<%= user2.getAddr()%>"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>