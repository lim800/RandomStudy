<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성별과 취미</title>
</head>
<body>
	<form action="./request.jsp" method="post">
		<fieldset>
			<table border="1">
				<tr>
					<td><label for="name">이름 </label></td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td><label for="gender">성별 </label></td>
					<td>남<input type="radio" name="gender" value="m" required>
						여<input type="radio" name="gender" value="f">
					</td>
				</tr>
				<tr>
					<td><label for="hobby">취미 </label></td>
					<td>독서<input type="checkbox" name="hobby" value="독서" checked>
						게임<input type="checkbox" name="hobby" value="게임"> TV시청<input
						type="checkbox" name="hobby" value="TV시청"> 축구<input
						type="checkbox" name="hobby" value="축구"> 기타<input
						type="checkbox" name="hobby" value="기타">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="전송"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>