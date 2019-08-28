<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>쿠키정보</td>
			<%
				Cookie[] cookie = request.getCookies();
				if (cookie == null) {
			%>
			<td>쿠키가 존재하지 않습니다</td>
			<%
				} else {
					for (int i = 0; i < cookie.length; i++) {
			%>
			<td><%=cookie[i].getName()%>(<%=cookie[i].getValue()%>)
				&nbsp;&nbsp;</td>
			<%
				}
				}
			%>
		</tr>
	</table>
</body>
</html>