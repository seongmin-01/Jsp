<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="entity.User1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	
	//데이터베이스 처리
	//String host = "jdbc:mysql://localhost:3306/studydb";
	//String user = "root";
	//String pwd = "1234";

	User1 user1 = null;
	
	try {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = DriverManager.getConnection(host, user, pwd);
		
		//Context는 JNDI에서 네이밍서비스를 이용하기 위해 사용하는 인터페이스
		Context initCtx = new InitialContext(); //JNDI 초기화
		Context ctx = (Context) initCtx.lookup("java:comp/evn"); //환경 설정이 저장된 디렉터리를 설정
		
		DataSource ds = (DataSource) ctx.lookup("jdbc/study"); //JNDI에서 등록한 데이터소스 찾기
		Connection conn = ds.getConnection();
		
		
		String sql = "select * from `user1` where `uid`= ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,uid);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()) {
			user1 = new User1();
			user1.setUid(rs.getString(1));
			user1.setName(rs.getString(2));
			user1.setHp(rs.getString(3));
			user1.setAge(rs.getInt(4));
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
	<title>user1::modify</title>
</head>
<body>
	<h3>user1 수정</h3>
	<a href="../1.jdbc.jsp">처음으로</a>
	<a href="./list.jsp">목록이동</a>
	
	<form action="./proc/modify.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<!-- readonly - 데이터입력을 막기 위해 사용 (id는 수정못하게 하기 위함) -->
				<td><input type="text" name="uid" value="<%= user1.getUid() %>" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= user1.getName() %>"></td>
			</tr>
			
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="<%= user1.getHp() %>"></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="<%= user1.getAge() %>"></td>
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