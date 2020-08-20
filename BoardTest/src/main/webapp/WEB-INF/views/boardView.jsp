<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>

<th>글번호</th>
<th>작성자</th>
<th>비밀번호</th>
<th>제목</th>
<th>내용</th>
<th>날짜</th>
<th>조회수</th>
<th>첨부파일</th>
</tr>


	<tr>
		<td>${boardView.bnum}</td>
		<td>${boardView.bwriter}</td>
		<td>${boardView.bpassword}</td>
		<td>${boardView.btitle}</td>
		<td>${boardView.bcontents}</td>
		<td>${boardView.bdate}</td>
		<td>${boardView.bhit}</td>
		<td><img src="resources/fileUpload/${boardView.bfilename}"/>
			<br/>${boardView.bfilename}</td>
	</tr>
</table>
<button onclick="location.href='boardModify?bnum=${boardView.bnum}'">수정하기</button> 
<button onclick="location.href='pagingList?page=${page}'">목록으로</button> 

</body>
</html>