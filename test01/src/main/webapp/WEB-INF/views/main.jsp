<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#loginbtn').click(function(){
			$(location).attr('href', '/no4/member/signin.no4');
		});
		
		$('#logoutbtn').click(function(){
			$(location).attr('href', '/no4/member/logout.no4');
		});
		$('#join').click(function(){
			$(location).attr('href', '/no4/member/signup.no4');
		});
		$('#memberlistbtn').click(function(){
			$(location).attr('href', '/no4/member/memberlist.no4');
		});
		$('#boardlistbtn').click(function(){
			$(location).attr('href', '/no4/board/boardList.no4');
		});
		$('#dataTablebtn').click(function(){
			$(location).attr('href', '/no4/member/dataTable.no4');
		});
		
	});
</script>
</head>
<body>
	<div class="w3-col m3"><p></p></div>
		<div class="w3-col m6 w3-center">
		<h1 class="w3-center w3-orange w3-padding">Main</h1>
			<div class="w3-col"><h5>Here is Main Page</h5></div>
				<c:if test="${not empty SID}">
					<div class="w3-button w3-orange w3-hover-aqua" id="logoutbtn">logout</div>
					<div class="w3-button w3-orange w3-hover-aqua" id="memberlistbtn">memberlist</div>
					<div class="w3-button w3-orange w3-hover-aqua" id="boardlistbtn">boardlist</div>
					<div class="w3-button w3-blue w3-red" id="dataTablebtn">dataTable</div>
				</c:if>
				
				<c:if test="${empty SID}">
					<div class="w3-button w3-blue w3-hover-aqua" id="loginbtn">login</div>
					<div class="w3-button w3-red w3-hover-aqua" id="join">join</div>
				</c:if>
	</div>
</body>
</html>