<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
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
section{
	margin:10px ;
	padding:3px; 
}
</style>

</head>
<body>
	<form action="memberjoin" method="GET">
		<div id="header">
			<h1>회원가입</h1>
			<section class="id">
				아이디: <input type="text" name="id" placeholder="아이디">
			</section>
			
			<section class="pw">
				비밀번호: <input type="password" name="password" placeholder="비밀번호">
			</section>

			<section class="name">
				이름:<input type="text" name="jsname" placeholder="이름">
			</section>

			<section class="birth">
				생년월일:<input type="Date" name="birth" placeholder="생년월일">
			</section>

			<section class="gender">
				성별: <input type="radio" name="gender" value="남자">남자 
				<input type="radio" name="gender" value="여자">여자
			</section>
			
			<section class="email">
				이메일: <input type="email" name="email" placeholder="이메일">
			</section>
			
			<section class="btn">
				<button onclick="">회원가입</button>
				<button type="reset">다시작성</button>
			</section>
			
		</div>
	</form>
</body>
</html>