<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import= "update.b.c.All.UpdateDTO" %>
    
    <%
        	ArrayList<UpdateDTO> arrayList = (ArrayList<UpdateDTO>)request.getAttribute("ddd");
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역명</th>
</tr>

<% for(int i=0; i<arrayList.size();i++) { %>
<tr>
<td><%=arrayList.get(i).getDeptno() %></td>
<td><%=arrayList.get(i).getDname() %></td>
<td><%=arrayList.get(i).getLoc() %></td>
</tr>

<% }%>
</table>
<br/>
<br/>
<form action="./SelectData" method="get">
<label for="deptno">부서번호입력: </label>
<input type="text" name ="deptno" required="required">
<input type="submit" value="수정" >
</form>

</body>
</html>