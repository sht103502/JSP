<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%int bNum=Integer.parseInt(request.getParameter("bNum")); %>
<% String bTitle=request.getParameter("bTitle"); %>
<% String bWriter=request.getParameter("bWriter"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardModify" method="POST" name="modiForm">
<table border="1">
 <tr>
 <td><input type="text" name="bNum" value="<%=bNum%>" readonly></td>
 </tr>
 <tr>
 <th>작성자 :</th>
 <td><%=bWriter %></td>
 </tr>
 <tr>
 <th>제목 : </th>
 <td><%=bTitle %></td>
 </tr>
 
 
 <tr>
 	<td>제목 : </td>
 	<td><input type="text" name="bTitle" size="39"></td>
 </tr>
 <tr>
 	<td>내용 : </td>
 	<td><textarea rows="20" cols="40" name="bContent"></textarea></td>
 </tr>
 <tr>
 	<td>첨부파일 : </td>
 	<td><input type="file" name="bFile"></td>
 </tr>
 
</table>
</form>
	<button onclick="aaa()">수정!</button>

	
</body>
<script>
function aaa(){
	modiForm.submit();
}

</script>
</html>