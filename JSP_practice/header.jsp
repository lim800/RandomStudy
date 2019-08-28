<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>헤더 이름</td>
			<td>헤더 값</td>
		</tr>
		<%
			Enumeration<String> enumeration = request.getHeaderNames();
			while (enumeration.hasMoreElements()) {
				String headerName = (String) enumeration.nextElement();
		%>
		<tr>
			<td><%=headerName%></td>
			<td><%=request.getHeader(headerName)%></td>
			<%
				}
			%>
		</tr>
	</table>
</body>
</html>