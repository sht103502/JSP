<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 검색창 -->
<h1>pagingList.jsp</h1>
	<form action="boardSearch" method="GET">
	검색조건 : <select name="type">
	<option value="BWRITER">작성자</option>
	<option value="BTITLE">제목</option>
	</select>
	
	검색어 : <input type="text" name="keyword"/>
	
	<input type="submit" value="검색">
</form>




<table border="1">
<tr>

<th>글번호</th>
<th>작성자</th>
<th>제목</th>
<th>날짜</th>
<th>조회수</th>
<!-- <th>사진</th> -->
<th>상세보기</th>
<th>삭제하기</th>



</tr>

<c:forEach var="board" items="${paginglist}">
	<tr>
		<td>${board.bnum}</td>
		<td>${board.bwriter}</td>
		<td>${board.btitle}</td>
		<td>${board.bdate}</td>
		<td>${board.bhit}</td>
		<%-- <td><img src="resources/fileUpload/${board.bfilename}"/></td> --%>
		<td><a href="boardView?bnum=${board.bnum}&page=${paging.page}">상세보기</a></td>
		<td><a href="boardDelete?bnum=${board.bnum}&page=${paging.page}">삭제</a></td>
		
	</tr>
</c:forEach>


</table>
<!-- 페이징 처리 -->
<%-- <c:if test="${paging.page<=1}">
<a href="pagingList?page=${paging.startpage}">[맨앞]</a>&nbsp;</c:if>
 --%>
<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>
	<c:if test="${paging.page>1}">
		<a href="pagingList?page=${paging.page-1}">[이전]</a>&nbsp;</c:if>

	<c:forEach begin="${paging.startpage}" end="${paging.endpage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			
			<c:otherwise>
				<a href="pagingList?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>

	</c:forEach>

	<c:if test="${paging.page>=paging.maxpage}">[다음]</c:if>
	<c:if test="${paging.page<paging.maxpage}">
		<a href="pagingList?page=${paging.page+1}">[다음]</a>&nbsp;</c:if>

	 <%-- <c:if test="${paging.page<=paging.maxpage}">
	 <a href="pagingList?page=${paging.endpage}">[맨뒤]</a>&nbsp;</c:if> --%>
</body>
</html>