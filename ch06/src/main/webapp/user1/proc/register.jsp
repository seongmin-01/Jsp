<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터 수신
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String age = request.getParameter("age");
	
	//데이터베이스 처리
	//String host = "jdbc:mysql://localhost:3306/studydb";
	//String user = "root";
	//String pwd = "1234";
	
	try {
		// 1단계 - JDBC 드라이버 로드
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2단계 - 데이터베이스 접속
		//Connection conn = DriverManager.getConnection(host, user, pwd);
		
		//JNDI 서비스 객체 생성
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env"); //JNDI 기본 환경 이름
		
		//커넥션 풀에 있는 커넥션을 가져오기
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
		
		//3단계 - SQL 실행 객체 생성
		String sql = "insert into `user1` values(?, ?, ?, ?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, age); //위에서 String으로 해당데이터를 받으므로 int가 아닌 String임
		
		//4단계 - SQL 실행
		psmt.executeUpdate();
		
		//5단계 결과셋 처리(select 경우) 
		
		//6단계 - 데이터베이스 종료
		psmt.close();
		conn.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	//목록 이동
	response.sendRedirect("../list.jsp");
%>