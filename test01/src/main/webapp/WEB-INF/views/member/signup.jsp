<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/join.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/no4/js/join.js"></script>
</head>
<body>
<div class="w3-col m3"><p></p></div>
	<div class="w3-center">
		<h1 class="w3-orange w3-padding">Join</h1>
			<div class="w3-col"><h5>Here is Join Page</h5></div>
				<form method="POST" action="./signupProc.no4" id="frm" name="frm">
					<div class="w3-col">
						아이디 : <input type="text" id="id" name="id" class="ckinput">
						<button type="button" class="w3-button w3-red" id="idCheck">ID Check</button><br>
						<small id="idmsg1" class="dnone d-block">이미 사용된 아이디입니다</small>
						<small id="idmsg2" class="dnone d-block">사용가능한 아이디입니다</small>
					</div>
					<div class="mar-rig">
						이름은 : <input type="text" id="name" name="name" class="ckinput">
					</div>
					<div class="mar-rig">
						비밀번 : <input type="text" id="pw" name="pw" class="ckinput">
					</div>
					<div class="mar-rig">
						비밀확 : <input type="text" id="repw" name="repw" class="ckinput">
					</div>					
						<small id="repwmsg1" class="dnone">비밀번호가 일치합니다.</small>
						<small id="repwmsg2" class="dnone">비밀번호가 일치하지 않습니다.</small>
					<div style="margin-left: 13px;">
						이메일 : <input type="text" id="email1" name="email1" class="ckinput">
						<span>@</span>
						<select id="email2" name="email2">
							<option value="@naver.com">naver.com</option>
							<option value="@daum.net">daum.net</option>
							<option value="@gmail.com">gmail.com</option>
							<option value="@nate.com">nate.com</option>
						</select>
						<button type="button" class="w3-button w3-orange" id="ckmail">이메일 인증</button>
						<br>
							인증번호입력 : <input type="text" id="mailck" name="mailck" style="margin-right:130px;" class="ckinput" placeholder="인증번호를 입력하세요">
							<button type="button" class="w3-button w3-blue" id="eokbtn">인증확인</button> 
						<div class="dnone" id="mailckbox">
							<span id="mailckBox"><button type="button" id="">이메일 인증 확인</button></span>
						</div>
							<br><small id="mailmsg1" class="mailckplz dnone" style="margin-left: 400px;">인증됨 ㅊㅊ</small>
							<br><small id="mailmsg2" class="mailckplz dnone" style="margin-left: 400px;">인증 ㅈ망, 다시 하센</small>
					</div>
					<div class="mar-rig">
						전화번 : <input type="text" id="tel" name="tel" class="ckinput">
					</div>
					<div class="" style="margin-right: 190px;">
						성별은 : <input type="radio" id="mgen" name="gen" value="M">남자
								 <input type="radio" id="wgen" name="gen" value="F">여자
					</div>
					<div class="dnone mavtbox">
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="11">
								<img src="../img/img_avatar1.png">
							</div>
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="12">
								<img src="../img/img_avatar2.png">
							</div>
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="13">
								<img src="../img/img_avatar3.png">
							</div>
					</div>
					
					<div class="dnone wavtbox">
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="14">
								<img src="../img/img_avatar4.png">
							</div>
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="15">
								<img src="../img/img_avatar5.png">
							</div>
							<div class="imgbox imgstyle">
								<input type="radio" name="ano" value="16">
								<img src="../img/img_avatar6.png">
							</div>
					</div>
			<button type="button" class="w3-button w3-yellow w3-margin-top" id="home">Home</button>
			<button type="button" class="w3-button w3-green w3-margin-top" id="join">SignUp</button>
			</form>
	</div>
</body>
</html>