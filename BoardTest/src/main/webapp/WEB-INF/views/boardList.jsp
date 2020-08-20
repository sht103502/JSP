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

<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>날짜</th>
<th>조회수</th>



</tr>

<c:forEach var="board" items="${board}">
	<tr>
		<td>${board.bnum}</td>
		<td>${board.bwriter}</td>
		<td>${board.btitle}</td>
		<td>${board.bdate}</td>
		<td>${board.bhit}</td>
	</tr>
</c:forEach>

</table>
</body>
</html>