<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
<%int count = Integer.parseInt(request.getParameter("cnt"));
			if (count == 0) {%>
	alert("삭제에 실패하였습니다.");
	location.href = "./dept_select";
<%} else {%>
	alert("삭제에 성공하였습니다.");
	location.href = "./dept_select";
<%}%>
	
</script>
</head>
<body>


</body>
</html>