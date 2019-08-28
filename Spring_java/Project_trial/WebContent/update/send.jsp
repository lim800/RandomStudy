<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.ArrayList" %>
    <%@ page import= "update.b.c.All.UpdateDTO" %>
    <%
    	ArrayList<UpdateDTO> arrayList = (ArrayList<UpdateDTO>)request.getAttribute("ddd"); 
        int deptno = 0;
        String dname = null;
        String loc = null;
        for(int i=0; i<arrayList.size();i++) {
        	deptno =arrayList.get(i).getDeptno();
        	dname =arrayList.get(i).getDname();
        	loc =arrayList.get(i).getLoc();
         }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<form action="./UpdateDAO" method="get">
부서번호 : <input type="text" name="deptno"  value=<%=deptno %> required>
부서명: <input type="text" name="dname"  value=<%=dname %> required>
지역: <input type="text" name="loc" value=<%=loc %> required>
<br/>
<input type="submit" value = "수정">

</form>
</body>
</html>