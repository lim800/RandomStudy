<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품주문</title>
</head>
<body>
	<form method="post" enctype="application/x-www-form-urlencoded">
		<fieldset class="fborder">
			<legend>주문하세요.</legend>
			<label for="itemId">상품1: </label> 
			<input type="text" id="itemId" name="list[0].itemId" size="20" /> 
				<label for="number">개수:</label> 
			<input type="text" id="number" name="list[0].number" size="20" /><br />
			<label for="itemId">상품2: </label> 
			<input type="text" id="itemId"name="list[1].itemId" size="20" /> 
			<label for="number">개수: </label> 
			<input type="text" id="number" name="list[1].number" size="20" /><br />
			<br /> <input type="submit" value="주문" />
		</fieldset>
	</form>

</body>
</html>