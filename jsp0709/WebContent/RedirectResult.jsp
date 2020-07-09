<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>RidirectResult Page</h1>
ID1 : <%=request.getParameter("userID") %>
PW : <%=request.getParameter("userPW") %>
request 속성값 :<%=request.getAttribute("requestName") %>

</body>
</html>
<!-- Redirect 방식
이 방식으로 포워딩 하게 되면 주소 표시줄의 주소가 변경된다.
-따라서 , 포워딩 된 jsp 페이지에서는 request 영역에 공유한속성값에 접근할 수 없다.
-request 영역을 공유하지 않는다.
 -->