<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section>
	제목 재설정: <input type="text" name="bTitle"id="bTitle" size="39">
	</section>
	<section>
	내용재설정:<textarea rows="20" cols="40" name="bContent"id="bContent"></textarea>
	</section>
	<button onclick="boardModify()">수정!</button>
	
</body>
<script>
function boardModify(){
	var bWriterConfirm = document.getElementById("bWriter").value;
	var bWriter = '${mbmodify.bWriter}';
	if (bWriterConfirm == bWriter) {
		modiForm.submit();
	} else {
		alert('아이디가 틀립니다.');
	}
}
</script>
</html>