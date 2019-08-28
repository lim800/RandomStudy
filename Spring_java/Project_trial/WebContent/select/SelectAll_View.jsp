
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="select.b.c.All.SelectDTO"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 	String name = request.getParameter("name");
	// 	String AllDept = request.getParameter("AllDept");
	ArrayList<SelectDTO> AllDept = (ArrayList<SelectDTO>) request.getAttribute("AllDept");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>부서 번호</td>
			<td>부서 직책</td>
			<td>지역</td>
		</tr>

		<%
			for (int i = 0; i < AllDept.size(); i++) {
		%>
		<tr>
			<td><%=AllDept.get(i).getDeptno() %></td>
			<td><%= AllDept.get(i).getDname() %></td>
			<td><%= AllDept.get(i).getLoc() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>