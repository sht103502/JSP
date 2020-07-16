<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,tr,td{
		border:1px solid black;
		border-collapse:collapse;
		text-align:center;
	}
</style>

</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>패스워드</td>
			<td>이름</td>
			<!-- <td>생년월일</td>
			<td>성별</td>
			<td>이메일</td> -->
			<td>상세조회</td>
			<td>탈퇴</td>
		</tr>
		<c:forEach var ="memberList" items="${memberList}">
		<tr>
			<td>${memberList.id}</td>
			<td>${memberList.password}</td>
			<td>${memberList.jsname}</td>
			<%-- <td>${memberList.birth}</td>
			<td>${memberList.gender}</td>
			<td>${memberList.email}</td> --%>
			<td><a href="memberView?id=${memberList.id}" >상세조회</a></td>
			<td><a href="memberDelete?id=${memberList.id}">탈퇴</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>