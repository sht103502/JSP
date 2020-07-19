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
<!-- 회원가입-->
<!-- 입력할수 있는 <input>태그를 다양하게 구성 -->
<!-- input type ="date" 달력을 나타나게 하고 선택할수 있음 -->
<!-- input type ="password" 문자,숫자를 입력하면 *로 표시되어짐 -->
<!-- input type ="radio" name이 동일하게 적혀있는 것중 하나만 선택이 가능함,
선택후 넘어가느 값은 value값!  -->
<!-- input type ="email" 이메일 형식으로 입력해야함-->
<!-- method="" GET,POST의 차이 GET은 입력된 값을 세션에 저장후 이동한 페이지의 주소창에value 값들을 보여준다.
POST는 session 에는 값을 저장하지만 주소창에 보여주지는 않는다. 그래서 비밀보장가능!   -->
	<form action="memberjoin" method="POST">
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
			<!-- value 값을 submit 완료시키는 단계 , 입력된 값 이녀석들을 제출하겠다. 
			submit 이 제출을하는데 action="memberjoin"의 값에 전달을 하겠다.서블릿으로 이동!
			 -->
				<input type="submit"value="회원가입">
			<!-- button type ="reset" form 안에 있는 값만 초기화 시킨다.  -->
				<button type="reset">다시작성</button>
			</section>
			<!-- memberjoin이 어디로 갈지는 모르지만 servlet파일중
			 webservlet("/memberJoin")이 작성된곳으로 이동!
			 JoinController.java파일에 작성 
			 ★ action 으로 보내는 값과 sevlet에서 받는 값이 같아야 한다. -->
		</div>
	</form>
</body>
</html>