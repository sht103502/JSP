<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,tr,td{
		border:2px solid black;
		border-collapse:collapse;
		text-align:center;
	}
	fieldset{
	text-align:center;
	}
	div{
	text-align:center;
	margin:10px 34%;
	}
</style>
</head>
<body>

<fieldset>
<legend><mark>회원 목록</mark></legend>
<div>
<table>
		<tr>
			<td>아이디</td>
			<td>패스워드</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>성별</td>
			<td>이메일</td>
			
		</tr>
		
		<tr>
			<td>${memberView.id}</td>
			<td>${memberView.password}</td>
			<td>${memberView.jsname}</td>
			<td>${memberView.birth}</td>
			<td>${memberView.gender}</td>
			<td>${memberView.email}</td>
			
		</tr>
	</table>
</div>
	</fieldset>
</body>
</html>