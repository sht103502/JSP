<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function LogOut(){
	location.href="memberLogout";
}
</script>
</head>
<body>
	<h2>${sessionScope.loginId}님 환영합니다!</h2>
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="memberList">회원목록 조회</a><br/><br/>
	</c:if>
	
	<button onclick="LogOut()">로그아웃</button>
</body>
</html>