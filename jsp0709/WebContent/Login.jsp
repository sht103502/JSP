<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,
td,
th{
	border:1px solid black;
	border-collapse: cpLLapse;
	padding:10px
}
table{
	width:300px;
	text-align:center;
}
</style>
</head>
<body>
<form action="RedirectServlet" method="POST">
<table>
        <caption>로그인 폼 만들기</caption>
        <tr>
            <th colspan="2"> 로그인</th>
            
        </tr>
        <tr>
            <th>ID</th>
            <td><input type="text" name="userID" placeholder="아이디"></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="password" name="userPW"placeholder="비밀번호"></td>
        </tr>
        <tr>
            <th>Number</th>
            <td><input type="text" name="num1"placeholder="비밀번호"></td>
        </tr>
        <tr class="btn">
            
            <td colspan="2">
                <input type="submit" value="로그인">
                <input type="button" value="회원가입">
            </td>
        </tr>
    </table>

    <hr>

    <!-- <fieldset>
        <legend>로그인</legend>
        <label>아이디 : <input type="text"></label><br>
        <label>비밀번호 : <input type="password"></label>
    </fieldset> -->
    </form>
</body>
</html>