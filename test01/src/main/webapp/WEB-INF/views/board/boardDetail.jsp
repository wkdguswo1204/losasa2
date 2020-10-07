<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 수정하기 버튼 함수
		$('#edit').click(function(){
			var sno = $(this).attr('id');
			$('#bno').val(sno);
			$('#bmno').val(sno);
			$('#frm').submit();
		});
		// 삭제하기 버튼 함수
		$('#delete').click(function(){
			var sno = $(this).attr('id');
			alert(sno);
			$('#bno').val(sno);
			$('#bmno').val(sno);
			$('#frm2').submit();
		});
	});
</script>
</head>
<body>
	<form method="POST" action="/no4/board/boardEdit.no4" id="frm" name="frm">
		<input type="hidden" name="bno" value="${DATA.bno}">
		<input type="hidden" name="bmno" value="${DATA.bmno}"> 
	</form>
		
	<form method="POST" action="/no4/board/boardDeleteProc.no4" id="frm2" name="frm2">
		<input type="hidden" name="bno" value="${DATA.bno}">
		<input type="hidden" name="bmno" value="${DATA.bmno}"> 
	</form>
	<div class="w3-col m3"><p></p></div>
		<div class="w3-col m7 w3-center">
		<h1 class="w3-center w3-orange w3-padding">BoardDetail</h1>
			<div class="w3-col"><h5>Here is BoardDetail Page</h5></div>
				<div class="w3-rwo w3-margin-top">
            		<div class="w3-col w3-padding w3-margin">
            		<!-- 조회수 -->
            		<div class="w3-right-align">
            		<span class="w3-right-align w3-col">조회수 : ${DATA.click}</span>
	            		<div class="w3-margin-bottom">
	            			
            			</div>
            			</div>
            			<br><br>
            		<!-- 글 제목 -->
	            		<span class="w3-left-align w3-col m2">제목 : </span>
	            		<div class="w3-border w3-left-align w3-col m6 w3-margin-bottom">
	            			${DATA.title}
            			</div>
            			<!-- 작성일자 -->
            			<div class="w3-right-align w3-col m4">
            				작성일자 : ${DATA.sdate}
            			</div>
            		<br><br><br>
            		<!-- 본문 내용 -->
            		<span class="w3-left-align w3-col m2">내용 : </span>
					<div class="w3-border w3-left-align w3-col m10 w3-margin-bottom">
            			<div id="editmode">
            			${DATA.body}</div>
            			</div>
            		</div>
            		
            		<div class="w3-right-align w3-margin-top">
                		<div class="w3-button w3-orange" id="edit">수정하기</div>
                		
                			<div class="w3-button w3-green" id="delete">삭제하기</div>                		
                		
                		<div class="w3-button w3-red" id="cancel">취소</div>
                	</div>
            		</div>
</div>
</body>
</html>