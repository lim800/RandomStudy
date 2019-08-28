<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"
  integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo="
  crossorigin="anonymous"></script>
<title>json</title>
</head>
<body>
	<script type="text/javascript">
		var data = {
			usr_id : "min",
			usr_pw : "1234",
			usr_name : "홍길동"
		};
		$.ajax(
				{
			url : "/jsonp",
			method : "POST",
			contentType : "application/json",
			data : JSON.stringify(data),
			success : function() {
				alert("전송 성공");
			},
			error : function(XHR, textStatus, errorThrown) {
				alert("오류: " + textStatus);
				alert("오류: " + errorThrown);
			}
		}
				);
	</script>
</body>
</html>