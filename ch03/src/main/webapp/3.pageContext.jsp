<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>3.pageContext</title>
	<!-- 
		날짜 : 2025/02/04
		이름 : 김성민
		내용 : JSP pageContxt 실습
	-->
</head>
<body>
	<h3>3.pageContext</h3>
	
	<h4>forward</h4>
	<a href="./proc/forward1.jsp">포워드 페이지 요청 #1</a> <br>
	<a href="./proc/forward2.jsp">포워드 페이지 요청 #2</a> <br>
	
	<h4>include</h4>
	<%
		//동적 include - 실행되는 시점에 동작함
		pageContext.include("./inc/_header.jsp");
		pageContext.include("./inc/_footer.jsp");
	%>
	
	<h4>include 지시자</h4>
	<%-- 정적 include - 실행되는 시점이 아닌 이미 되어있는 상태인거임.--%>
	<%@ include file="./inc/_header.jsp" %>
	<%@ include file="./inc/_footer.jsp" %>
</body>
</html>