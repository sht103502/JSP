<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="test" value="Hello Jstl!"/> 
<!-- 변수 설정 태그 사용 -->
<!-- String test ="Hello Jstl!" 이랑 같은 맥락이다 -->

<h3>c:set 사용후 :<c:out value="${test}"/></h3>
<!-- 출력 태그 사용 -->

<c:remove var="test"/>
<!-- 삭제 태그 사용 -->
<h3>c:remove 사용후: <c:out value="${test}"/></h3>

<c:catch var ="err">
<%=10/0 %>
<!-- 10을 0으로 나눌수 없으니깐 예외처리-->
</c:catch>
<h3>c:catch 로 잡아낸 오류:  <c:out value ="${err}"/></h3>

<c:if test="${5<10}">
<h3>참일경우 출력: 5는 10보다 작다. </h3>
</c:if>
<c:if test="${6+3==10}">
<h3>거짓일 경우 출력하지 않는다 6+3=10</h3>
</c:if>

<c:choose>
	<c:when test="${5+10==50 }">
		<h3>참이면 출력, 거짓이면 출력하지 않는다.</h3>
	</c:when>
	<c:otherwise>
		<h3>5+10은 50이 아니다.</h3>
	</c:otherwise>
</c:choose>

<c:forEach var="foreach" begin="1" end="10" step="2">
${foreach}&nbsp;
<!-- &nbsp : 한칸 공백 띄우는것 -->
</c:forEach>
</body>
</html>