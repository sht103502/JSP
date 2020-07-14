<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>DispatcherResult Page</h1>
ID1 : <%=request.getParameter("userID") %>
PW : <%=request.getParameter("userPW") %>
request 속성값 :<%=request.getAttribute("requestName") %>


</body>
</html>
<!-- Dispatcher 방식
-이방식으로 포워딩하게 되면 주소표시줄의 
주소가 변경하지 않는다.
-즉, 하나의 요청이라는 의미
-request 영역을 공유한다. -->