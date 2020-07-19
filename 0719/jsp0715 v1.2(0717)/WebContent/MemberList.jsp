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
<!-- LoginSuccess.jsp 에서  scope로 불러온 값이 
eq(equal:'admin'이랑  비교해서) 성립이 되면 
memberList로 이동되어짐! -->

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
		<!-- listController에서 name="memberList"의 값 memberList의 id 값을 나타냄 -->
		<c:forEach var ="member" items="${memberList}">
		<!-- var=변수명 items="값" -->
		<!-- c:forEach 배열 요소를 순서대로 반복해서 처리할 수 있는 태그 -->
		<tr>
			<td>${member.id}</td>
			<!-- 변수명 member의 id값 -->
			<td>${member.password}</td>
			<!-- 변수명 member의 password값 -->
			<td>${member.jsname}</td>
			<!-- 변수명 member의 jsname값 -->
			<%-- <td>${member.birth}</td>
			<td>${member.gender}</td>
			<td>${member.email}</td> --%>
			<td><a href="memberView?id=${member.id}" >상세조회</a></td>
			<td><a href="memberDelete?id=${member.id}">탈퇴</a></td>
		</tr>
		<!-- ★${memberList}값은  c태그 안에서만 사용가능, 나가면 사용불가★  -->
		</c:forEach>
	</table>
</body>
</html>