<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성별과 취미</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=request.getParameter("name")%></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%
					if (request.getParameter("gender").equals("m")) {
				%> 남자 
				<%
					} else {
				%> 여자 <%
					}
				%>
			</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<%
					String[] hobby = request.getParameterValues("hobby");
					for (int i = 0; i < hobby.length; i++) {
						
						
						
				%> 
				
				<font><%=hobby[i]%> &nbsp;&nbsp; 
				</font>
				
				<%
 	}
 %>
			</td>
		</tr>
	</table>
</body>
</html>