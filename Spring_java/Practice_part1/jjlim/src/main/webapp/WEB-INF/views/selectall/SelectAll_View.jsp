
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="lachata.spring.jj.dept_dto.DeptDTO" %>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<DeptDTO> AllDept = (ArrayList<DeptDTO>) request.getAttribute("selectAll");
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
			<td><%=AllDept.get(i).getDeptno()%></td>
			<td><%=AllDept.get(i).getDname()%></td>
			<td><%=AllDept.get(i).getLoc()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>