
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action=" ../SelectDAO" method="get"
		enctype="application/x-www-form-urlencoded">
		<fieldset>
			<label for="name">deptNo</label>
			<input type="text" name="deptno" required> 
			<input type="submit" value="deptno submit"> <br />
		</fieldset>
	</form>
	
	<input type="button" value="전체조회" onclick="location.href='../SelectAllDAO'">
</body>
</html>