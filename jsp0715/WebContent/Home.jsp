<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#header {
	background-color: rgb(245, 243, 118);
	width: 100%;
	height: 100px;
	line-height: 100px;
	margin-bottom: 10px;
	/* margin :0px 0px 10px 0px */
}

div {
	text-align: center;
	border-radius: 15px;
}

li {
	background-color: rgb(245, 243, 118);
	color: white;
	width: 120px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	font-weight: bold;
	font-size: 20px;
	border-radius: 5px;
	display: inline-block;
	margin: 10px;
	height: 40px;
}

li:hover {
	background-color: yellowgreen;
}

body {
	background-image: url('오구.gif');
	background-size: unset;
}

</style>
<script>
function memberJoin(){
	location.href="MemberJoin.jsp";
}
function login(){
	location.href="LoginForm.jsp ";
}

</script>
</head>
<body>
	
		<fieldset>
			<legend>Maver</legend>

			<table>

				<div id="header">
					<ul>
						<!-- <li><a href="1.html"><img src="icons1.png" alt="">관리자</a></li> -->
						<!-- <li><a href="2.html"><img src="icons2.png" alt="">회원가입</a></li> -->
						<li><a href=""><img src="" alt="">입장</a></li>
					</ul>
				</div>
			</table>
			<button onclick="memberJoin()">회원가입</button>
			<button onclick="login()">로그인</button>
		</fieldset>

	
	로그인 회원가입

</body>
</html>