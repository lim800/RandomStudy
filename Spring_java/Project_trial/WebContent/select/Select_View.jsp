
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 	String name = request.getParameter("name");
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%=name%> --%>
		<%=deptno%>
		<%=dname%>
		<%=loc%>
<script type="text/javascript">
location.href = "../Index.jsp"
</script>
</body>
</html>