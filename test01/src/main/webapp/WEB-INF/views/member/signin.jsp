<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/no4/js/login.js"></script>
</head>
<body>
<div class="w3-col m3"><p></p></div>
		<div class="w3-col m6 w3-center">
		<h1 class="w3-center w3-orange w3-padding">Login</h1>
			<div class="w3-col"><h5>Here is Login Page</h5></div>
			<form method="POST" action="./signinProc.no4" id="frm" name="frm">
				아이디 : <input type="text" id="id" name="id"><br>
				비밀번 : <input type="text" id="pw" name="pw"><br>

				<button type="button" class="w3-button w3-yellow w3-margin-top" id="login">Login</button>
			<button type="button" class="w3-button w3-green w3-margin-top" id="home">Home</button>
			</form>
				<button type="button" class="w3-button w3-orange" id="idbtn">아디찾기</button>
				<button type="button" class="w3-button w3-blue" id="pwbtn">비번찾기</button>
				<!-- 아디찾기 -->
				<div id="idt" class="dnone">
					아이디 찾기 채움란
					<div id="id1"> 이름 : 
						<input type="text" id="mname" name="id">
					</div>
					<div id="id2"> 메일 : 
						<input type="text" id="memail2" name="memail">
					</div>
				<form method="POST" action="/no4/member/idfind.no4" id="frm2">
					<button type="button" class="w3-button w3-red" id="sendmail2">인증메일</button>
				</form>
				</div>
				<!-- 여기까지 -->
				<!-- 비번찾기 -->
				<div id="pwt" class="dnone">
				비밀번호 찾기 채움란
					<div id="pw1"> 아디 : 
						<input type="text" id="mid" name="id">
					</div>
					<div id="pw2"> 메일 : 
						<input type="text" id="memail" name="memail">
					</div>
				<form method="POST" action="/no4/member/pwfind.no4" id="frm2">
					<button type="button" class="w3-button w3-red" id="sendmail">인증메일</button>
				</form>
				</div>
				
				<!-- 여기까지 -->
		       </div>
</body>
</html>