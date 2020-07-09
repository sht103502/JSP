<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginTest Page</title>
</head>
<body>
<h1>LoginTest Page</h1>

<h3>id: <%=request.getParameter("userID") %></h3>
<h3>pw: <%=request.getParameter("userPW") %></h3>
</body>
</html>