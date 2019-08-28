<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드</title>
</head>
<body>
	포워드가 되면 경로가 바꾸지 않는다.
	<%
	pageContext.forward("./pagecontext.jsp");
%>
</body>
</html>