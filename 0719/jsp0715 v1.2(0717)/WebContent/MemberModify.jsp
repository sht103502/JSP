<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: auto;
	text-align: center;
}
fieldset{
margin-left:40%;
margin-right:40%;
}
</style>

</head>
<body>
	<fieldset>
		<div>
			<h1>회원정보 수정</h1>
			현재아이디: ${mbmodify.id}<br /> 현재비밀번호: ${mbmodify.password}<br />
			현재이름: ${mbmodify.jsname}<br /> 현재생년월일:${mbmodify.birth}<br /> 현재성별:
			${mbmodify.gender}<br /> 현재이메일: ${mbmodify.email}<br />
		</div>
	</fieldset>
	<fieldset>
	<form action="ModifyProcess" method="POST" name="modiForm">
		<div id="header">
			<h1>회원가입</h1>
			<section class="id">
				아이디: <input type="text" name="id" id="id" placeholder="아이디">
			</section>

			<section class="pw">
				비밀번호: <input type="password" name="password" id="password"
					placeholder="비밀번호">
			</section>

			<section class="name">
				이름재설정:<input type="text" name="jsname" id="jsname" placeholder="새로운이름">
			</section>

			<!-- <section class="birth">
				생년월일:<input type="Date" name="birth" id="birth" placeholder="생년월일">
			</section>

			<section class="gender">
				성별: <input type="radio" name="gender" id="gender" value="남자">남자
				<input type="radio" name="gender" value="여자">여자
			</section> -->

			<section class="email">
				이메일재설정: <input type="email" name="email" id="email" placeholder="새로운이메일">
			</section>
		</div>
	</form>
	<button onclick="memberModify()">정보수정</button>
	<button onclick="goMain()">메인으로</button>
	</fieldset>
</body>
<script>
	function memberModify() {
		var passwordConfirm = document.getElementById("password").value;
		var password = '${mbmodify.password}';
		if (passwordConfirm == password) {
			modiForm.submit();
		} else {
			alert('비밀번호가 틀립니다.');
		}
	}
	function goMain() {
		location.href = "Home.jsp";
	}
</script>
</html>