<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인창</h1>
<!-- 로그인  -->
<!-- 아이디와 비밀번호를 입력할 수 잇는 <input>태그 생성-->
<!-- 입력한 값을 <input type="submit">으로 제출한다. -->
<!-- 로그인 버튼을 누르면 form action="memberLogin으로 간다."-->
<!-- method="POST"session에는 저장되지만 보안성을 유지한다!  -->
<!-- LoginFrom.jsp > LoginControllerServlet(memberLogin)
>LoginService>MemberDAO>LoginService>LoginCotroller로 돌아오고
 로그인이성공하면 LoginSuscess.jsp 실패하면 LoginFail.jsp 로 간다.-->
<form action="memberLogin" method="POST">

아이디: <input type="text" name="id">
비밀번호: <input type="password" name="password">
<input type="submit" value="로그인"/>
<!-- <button onclick="">로그인</button> -->
</form>
</body>
</html>