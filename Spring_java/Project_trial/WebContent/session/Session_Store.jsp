<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%=session.getId()%>
<%session.setAttribute("name", "홍길동"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	location.href="./Session_Send.jsp";
</script>
</body>
</html>