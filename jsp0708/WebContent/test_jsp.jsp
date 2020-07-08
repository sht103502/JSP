<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.Calendar" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Calendar c =Calendar.getInstance();
	int hour =c.get(Calendar.HOUR_OF_DAY);
	int minute =c.get(Calendar.MINUTE);
	int second =c.get(Calendar.SECOND);
%>
</head>
<body>
<h1>현재시간은 <%=hour%>시 <%=minute%>분 <%=second%>초 입니다.</h1>
<!-- 
	1.HTTP(HyperTextTransferProtocal)
		-네트워크에 연결된 컴퓨터가 서로 통신하기 위한 프로토콜
		-www서비스를 위한 프로토콜로 웹 서버와 클라이언트는
		http를 이용한다.
		-프로토콜 이란 통신규약을 의미한다.
		-요정(Request)와 응답(Response)로 이루어져 있다.
		 
	2.Web Browser
		-웹의 정보를 쉽게 참조할 수 있도록 고안된 응용프로그램
		-웹은www를 의미하며, World Wide Web을 줄인말이다.
	
	3.DNS(Domain Name System)
		-숫자로 된 아이피 주소를 문자로 변환하는 시스템
		-일반적으로 도메인이라 부른다.
		-IP주소를 알려주거나 IP주소에 대한 도메인 이름을 알려주는 역할
		-ex) cmd에서 nslookup www.naver.com을 입력해서 
		실제 IP주소 확인하기
	
	4.서버와 클라이언트(Server & Client)
	-서버(Server) :서비스를 제공한느 컴퓨터
	-웹서버(Web Server) :웹페이지가 들어있는 파일을
	사용자들에게 제공하는 컴퓨터
	-클라이언트(Client) :서비스를 제공받는 컴퓨터
	
	-대표적인 웹서버 :아파치(Apache) ,인터넷정보서버(IIS),
	엔터프라이즈 서버 등등..
	
	5.정적 웹서비스와 동적 웹서비스
	1) HTML(Hyper Text Markup Language)
	-웹 문서를 만들기 위해 사용하는 기본적인 프로그래밍 언어의 한종류
	-정적 웹서비스를 제공한다.
	
	2)JavaScaipt
	-객체 지향 스크립트 언어로 웹페이지의 동작을 담당
	
	3)Jsp
	-HTML 내에 자바코드를 삽입하여 웹서버에서 동적으로 웹페이지를 생성한다.
	-생서된 웹페이지를 웹브라우저에 돌려주는 언어로 도적인 웹서비스 제공
	
 -->
</body>
</html>