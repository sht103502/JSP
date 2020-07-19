<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/*LoginController에서 resopnse.sendRedirect("")로 LoginFail.jsp 로 이동하게 되면! 
alert창으로 ()가 뜨게 하였다.*/
alert("로그인 실패! 홈으로 돌아갑니다!")

 setTimeout(function() {
	 /* setTimeout을 이용해 일정 시간(1초)이 지난 후에 overMain()를 실행*/
	overMain();
},1000);
function overMain(){
	/*overMain() 은 Home.jsp로 이동하는 function을 만들어주었다. */
	location.href="Home.jsp";
} 
</script>
</head>
<body>

</body>
</html>