<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>작성자</th>
			<th>비밀번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th colspan="2">기능</th>
		</tr>
		<!--ListController에서  if(ctrlList != null) {
			request.setAttribute("jspList", ctrlList); 여기에 해당함-->
		<!--검색경과 (갯수)만큼 반복해서 출력된다.  -->
		<c:forEach var="boardList" items="${jspList}">
			<tr>
				<td>${boardList.bWriter}</td>
				<td>${boardList.bPassword}</td>
				<td>${boardList.bTitle}</td>
				<td>${boardList.bContent}</td>
				<td>${boardList.bDate}</td>
				<td><a href="boardView?bTitle=${boardList.bTitle}">상세조회</a></td>
				<td><a href="boardDelete?bTitle=${boardList.bTitle}">삭제</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><button onclick="location.href='BoardWrite.jsp'">글쓰기</button></td>
		</tr>


	</table>
</body>
</html>