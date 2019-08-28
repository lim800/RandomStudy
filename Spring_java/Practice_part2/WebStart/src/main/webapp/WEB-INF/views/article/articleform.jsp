<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
<style type="text/css">
.fborder {
	border: 1px;
}
</style>

</head>
<body>
	<form method="post" enctype="application/x-www-form-urlencoded">
		<fieldset class="fborder">
			<legend>글을 등록하세요</legend>
			<input type="hidden" name="number" value="1" /> 
			<label for="title">제목: </label> 
			<input type="text" id="title" name="title" size="20" /> 
			<br /> 
			<label for="content">내용: </label>
			<textarea id="content" rows="30" cols="50" name="content"></textarea>
			<br/>
			<input type="submit" value="전송">
		</fieldset>
	</form>

</body>
</html>