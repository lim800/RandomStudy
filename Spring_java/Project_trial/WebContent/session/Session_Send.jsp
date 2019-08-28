<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.String"%>
<%=session.getId()%><!-- 3E2B02FAA82FB87AAFB1742C08F39555 -->
<%
	String name;

	if(session.getAttribute("name") != null){
		name = (String)session.getAttribute("name");
	}else{
		name="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션값 <%=name %>
	<input type = "button" onclick="location.href='./Session_Store.jsp'" value="세션 저장">
	<input type = "button" onclick="location.href='./Session_Remove.jsp'" value="세션 삭제">
	<input type = "button" onclick="location.href='./Session_Ini.jsp'" value="세션 초기화">
</body>
</html>