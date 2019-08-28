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
	alert("새로운 데이터가 추가되었습니다.");
	location.href = "../Index.jsp"
<%} else {%>
	alert("데이터 추가에 실패하였습니다.");
	history.back();
<%}%>
	
</script>
<meta charset="UTF-8">
<title>storageview</title>
</head>
<body>

</body>
</html>