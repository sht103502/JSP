<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>	
<body>
 <img src="<spring:url value='/resources/fileUpload/2.PNG'/>"> 
 <img src="<spring:url value='/resources/fileUpload/fileUpload3.gif'/>">  

	<button onclick="location.href='boardForm'">글쓰기</button>
	<button onclick="location.href='pagingList'">목록보기</button>
	
</body>
</html> 