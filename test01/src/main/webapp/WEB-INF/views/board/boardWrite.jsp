<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#save').click(function(){
			$('#frm').submit();
		});
	});
</script>
</head>
<body>
<body>
	<div class="w3-col m3"><p></p></div>
		<div class="w3-col m6 w3-center">
			<h1 class="w3-center w3-orange w3-padding">Board</h1>
			<h5>Here is BoardWrite Page</h5>
			<div class="w3-col w3-row w3-center"></div>
				<form method="POST" action="/no4/board/boardWriteProc.no4" id="frm" name="frm">
				<!-- 제목 적는 란 -->
				<div class="">
					<span class="w3-col m1">제목 : </span><div class="w3-col m11 w3-card w3-padding">
					<input type="text" class="w3-input w3-border-0" name="title" id="title" placeholder="제목 입력란">
					</div>
				</div>
				<br><br>
				<!-- 본문 적는 란 -->
				<span class="w3-col m1 w3-margin-top">내용 : </span><div class="w3-col m11 w3-card w3-padding w3-margin-top"> 
				  <div class="w3-row w3-margin-top w3-left-align"></div>
            		<div class="w3-row">
                		<div class="w3-margin-bottom w3-margin-top">
                    	<textarea class="w3-border-0" name="body" id="body" cols="10" rows="5" placeholder="본문 입력란" style="resize: none;"></textarea>
                </div>
                </div>
            </div>
				
				<div class="w3-margin-top">
	                <div class="w3-button w3-red" id="save">완료</div>
	                <div class="w3-button w3-green" id="cancel">취소</div>
                </div>
				</form>
	</div>
</body>
</html>