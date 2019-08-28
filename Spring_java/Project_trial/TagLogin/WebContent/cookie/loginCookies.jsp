<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 로그인</title>
</head>
<body>
<div>
<section>
<form action="../CookieLogin.do" method="post">
<fieldset>
<legend>쿠키 로그인 폼</legend>
<p>
<label for="id">아이디</label>

<input type="text" name="id" required="required">
</p>
<p>
<label for="pass">비밀번호</label>
<input type="password" name="pass" required="required">
</p>
<p>
<button type ="submit">로그인</button>
</p>
<br/> 쿠키사용
<input type="checkbox" name="cookie">
</fieldset>


</form>

</section>

</div>

</body>
</html>