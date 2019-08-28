<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="/resources/css/jboard.css">
</head>
<body>
	<div id="contentsArea">
		<section id="titlename" class="qnaBoard">
			<h1>게시판</h1>
			<div id="infoArea">
				<section class="search">
					<form name="search" action="./BoardList.do" method="post">
						<fieldset>
							<legend>검색</legend>
							<label for="keyword"></label>
							<select name="type" class="b_search">
								<option value="all" selected="selected">전체 검색</option>
								<option value="subject">제목</option>
								<option value="name" >글쓴이</option>
								<option value="content" >내용</option>
							</select> 
							<input type="search" id="keyword" name="keyword" required="required" placeholder="검색어 입력해">
							<button type="submit">검색</button>
						</fieldset>
					</form>
				</section>
			</div>
			<p class="allPost">
				전체 글: &nbsp; <strong><c:out value="${totalNum}"/></strong>개
			</p>
			<table class="boardTable">
				<caption>게시판 리스트</caption>
				
				<caption>게시판 리스트</caption>
				<c:choose>
					<c:when test="${totalNum>0}">
					
						<thead>
							<tr>
								<th scope="col" class="bbsNumber">번호</th>
								<th scope="col" class="bbsTitle">제목</th>
								<th scope="col" class="bbsAuthor">글쓴이</th>
								<th scope="col" class="bbsDate">등록일</th>
								<th scope="col" class="bbsHit">조회수</th>
							</tr>
						</thead>
					<c:forEach var="board" items="${boardList}" varStatus="status">
							<tbody>
								<tr>
									<td><c:out value="${board.num}" /></td>
									<td><c:if test="${!empty board.answer_lev}">
											<c:forEach var="j" begin="0" end="${board.answer_lev*2}" step="1">
												&nbsp; 
											</c:forEach>
										</c:if> 
										<a href="./BoardDetailService.do?num=<c:out value="${board.num}" />"><c:out value="${board.subject}" /></a>
									</td>
									<td><c:out value="${board.name}" /></td>
									<td><c:out value="${board.write_date}" /></td>
									<td><c:out value="${board.read_count}" /></td>
								</tr>

							</tbody>
					</c:forEach>
				</c:when>
				</c:choose>
						</table>						
							
							<div align="center">
								<table id="boardTableNe" class="boardTableNe">
									<tbody>
									<c:if test="${totalNum==0}">
									
						<tr>
							<td colspan="4"></td>
							<td>등록된 글이 없습니다.</td>
						</tr>
						</c:if>
							<tr>
											<td colspan="5">
											${pageHtml}	
														
											</td>
										</tr>
				
				</tbody>
				</table>
				
				<div class="btnJoinAreb">
					<button type="button" value="button" onclick="location.href='/Boardwrite.do'" class="btnOk">글쓰기</button>
				</div>				
			</div>
			
		</section>
	</div>
</body>
</html>