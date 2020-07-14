<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL_Test</title>
</head>
<body>
	<h2>sessionScope : ${sessionScope.test}</h2>
	<h2>param : ${param.name}</h2>
	<br>
	
	<h2>sessionScope : <%= session.getAttribute("test") %></h2>
	<h2>param : <%= request.getParameter("name") %></h2>
</body>
</html>