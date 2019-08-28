<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
<%int count = (int) request.getAttribute("count");
 	if (count > 0) {%>
	alert("신규 데이터를 생성하셨습니다.");
	location.href = "/InsertDAO";
<%} else {%>
	alert("신규 데이터 생성에 실패하셨습니다.");
	history.back();
<%}%>
	
</script>
</head>
<body>



</body>
</html>