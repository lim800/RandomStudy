<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인</title>
<script type="text/javascript">
	parent.leftFrame.location.href="./session/menu.jsp"
</script>
</head>
<body>
<c:out value="${sessionScope.loginDTO.name }"/> 님 로그인 성
</body>
</html>