<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int cnt = Integer.parseInt(request.getParameter("cnt"));
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
<%if (cnt > 0) {%>
	alert("수정에 성공하였습니다.");
	location.href = "./Selectlist"
<%} else {%>
	alert("수정에 실패하였습니다.");
	history.back();
<%}%>
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>