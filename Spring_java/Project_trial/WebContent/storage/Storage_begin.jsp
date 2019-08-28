<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send</title>
</head>
<body>

<form action="../StorageServlet" method="get">
Deptno: <input type="text" name="deptno" required="required"><br/>
Dname: <input type="text" name="dname" required="required" ><br/>
Loc: <input type="text" name="loc" required="required"><br/>
<input type="submit">
</form>

</body>
</html>