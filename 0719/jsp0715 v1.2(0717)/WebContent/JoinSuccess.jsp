<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/* 회원가입 성공시 열리는 페이지
alert로 회원가입 성공이라고 오류창이 뜨게 만들었고
1초뒤에 Home.jsp 로 이동!
*/
alert("회원가입성공! 홈으로 돌아갑니다!");
setTimeout(function() {
	overMain();
},1000);
function overMain(){
	location.href="Home.jsp";
} 
</script>
</head>
<body>

</body>
</html>