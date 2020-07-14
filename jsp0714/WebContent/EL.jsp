<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% session.setAttribute("test", "SessionTest"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
<style>
	fieldset{
		width: 300px;
		height: 50px;
	}
</style>
</head>
<body>
	 <form action="EL_Test.jsp" method="GET">
	 	<fieldset>
	 		<legend>EL_Test.jsp로 보내기</legend>
	 		<input type="text" name="name" value="희태"/>
	 		<input type="submit" value="전송"/>
	 	</fieldset>
	 </form>
</body>
</html>