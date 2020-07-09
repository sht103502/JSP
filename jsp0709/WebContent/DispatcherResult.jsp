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