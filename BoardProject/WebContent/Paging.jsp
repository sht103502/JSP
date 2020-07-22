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
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<!-- itmes는 마음대로 쓰는것이 아닌 값을 넘겨준 것으로 넘겨줘야함
		var는 아무거나 해도상관없음! -->
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bNum}</td>
				<td>${board.bWriter}</td>
				<td><a href="boardView?bNum=${board.bNum}&page=${paging.page}">${board.bTitle}</a></td>
				<td>${board.bDate}</td>
				<td>${board.bHit}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 페이징 처리 -->
	
	 <c:if test="${paging.page>=1}">
	 <a href="pagingList?page=${paging.startPage}">[맨앞]</a>
	 </c:if>
	
	<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>
	<c:if test="${paging.page>1}">
		<a href="pagingList?page=${paging.page-1}">[이전]</a>
	</c:if>

	<c:forEach begin="${paging.startPage}" end="${paging.endPage }" var="i"
		step="1">
			
		<c:choose>
			<c:when test="${i eq paging.page}">
				${i}
			</c:when>
			<c:otherwise>
				<a href="pagingList?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>

	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">[다음]</c:if>
	<c:if test="${paging.page<paging.maxPage}">
		<a href="pagingList?page=${paging.page+1}">[다음]</a>
	</c:if>

	 <c:if test="${paging.page<=paging.maxPage}">
	 <a href="pagingList?page=${paging.endPage}">[맨뒤]</a>
	 </c:if>
</body>
</html>



<!-- <a href="boardView?bNum=${board.bNum}&page=${paging.page}">-->
<!-- href =boardView => form태그에서 action=boardView -->
<!-- bNum=${board.bNum} form태그에서 name=bNum을 &{board.bNum}으로  -->
<!-- method=GET 방식으로 넘긴 것과 같은 것을 의미한다. -->


