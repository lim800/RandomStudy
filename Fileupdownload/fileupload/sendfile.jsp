<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../Upload.do" method="post" enctype="multipart/form-data">
<table border="1">

<tr>
<td>이름</td>
<td><input type="text" name="name" required="required"></td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" name="subject" required="required"></td>
</tr>
<tr>
<td>파일명</td>
<td> <input type="file" name="filename" required="required"></td>
</tr>
<tr>
<td><input type="submit"></td>
</tr>


</table>
</form>
</body>
</html>