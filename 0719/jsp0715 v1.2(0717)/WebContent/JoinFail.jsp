<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/* 회원가입이 실패했을 경우 해당페이지가 열린다. alert창으로 회원가입실패가 뜨고
버튼을 클릭하면  1초뒤에 Home.jsp로 이동한다.*/
alert("회원가입실패!");
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