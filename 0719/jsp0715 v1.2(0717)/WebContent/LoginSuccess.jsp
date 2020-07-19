<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <% request.setCharacterEncoding("UTF-8");%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function LogOut(){
	//로그아웃 버튼 클릭시 실행
	location.href="memberLogout";
}
function memberModify(){
	//회원수정 버튼 클릭시 실행
	location.href="memberModify";
}
</script>
<style>
body{
	margin:auto;
	text-align:center;
}
</style>
</head>
<body>
<!-- loginId의 값을 불러오기위한 방법은 2가지 -->
<!-- Parameter 방법과 scope방법이 있다.-->
<!-- "${sessionScope.user}" -->
<!-- ${param.str} -->
	<h2>${sessionScope.loginId}님 환영합니다!</h2>
	<c:if test="${sessionScope.loginId eq 'admin'}">
	<!-- JSTL(Jsp Standard TagLibrary) 조건 태그 -->
	<!-- - test : 필수 속성으로 속성값으로 EL 비교식(ELOperator:기본, 산술, 관계형,조건, 논리, empty로 구분)을 가집니다.
		 - var : 조건 결과를 저장할 변수를 지정합니다.
		 - scope : 조건 결과를 저장할 변수의 저장 scope을 지정합니다.
	-->
		<a href="memberList">회원목록 조회</a><br/><br/>
		<!-- scope로 불러온 값이 eq(equal:'admin'이랑  비교해서) 성립이 되면 
		memberList로 이동 -->
	</c:if>
	<button onclick="memberModify()">회원수정</button>
	<!--회원수정 버튼 클릭시 memberModify()라는 function 실행  -->
	<button onclick="LogOut()">로그아웃</button>
	<!--로그아웃 버튼 클릭시 LogOut()라는 function 실행  -->
</body>
</html>