<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="delete.b.c.All.DeptDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서</th>
		</tr>
		<%
			ArrayList<DeptDTO> arrayList = (ArrayList<DeptDTO>) request.getAttribute("dept");
			for (int i = 0; i < arrayList.size(); i++) {
		%>
		<tr>
			<td><%=arrayList.get(i).getDeptno()%></td>
			<td><%=arrayList.get(i).getDname()%></td>
			<td><%=arrayList.get(i).getLoc()%></td>
		</tr>
		<%
			}
		%>

	</table>

<form action="./dept_delete" method = "get">
<label for = "deptno"> </label>
<input type = "text" name="deptno"/>
<input type = "submit" value= "검색"/>
</form>

</body>
</html>