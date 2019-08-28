<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 페이지</title>
</head>
<body>
<c:choose>
	<c:when test="${empty loginDTO }">
	<a href="./loginSession.jsp" target="rightFrame"> 로그인 </a>
	</c:when>
	<c:otherwise>
	<a href="..Logout.do" target="rightFrame"> 로그아웃 </a>
	</c:otherwise>
</c:choose>
</body>
</html>