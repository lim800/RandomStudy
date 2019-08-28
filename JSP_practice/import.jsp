<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 날짜와 시간</title>
</head>
<body>
 현재 날짜와 시간은 <%=new SimpleDateFormat().format(new Date())%>입니다.
</body>
</html>