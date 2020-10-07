<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardEdit</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
 		$('#editend').click(function(){
 			var title = $('#title2').val();
 			var body = $('#body2').val();
 			$('#title').val(title);
 			$('#body').val(body);
			$('#frm').submit();
		});
	});
</script>

</head>
<body>
<form method="post" action="/no4/board/boardEditProc.no4" id="frm">
	      <%-- <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}"> --%>
	      <input type="hidden" id="bno" name="bno" value="${DATA.bno}">
	      <input type="hidden" id="title"name="title" value="${DATA.title}">
	      <input type="hidden" id="body"name="body" value="${DATA.body}">
	      <input type="hidden" id="name" name="name" value="${DATA.name}">
	      <input type="hidden" id="click" name="click" value="${DATA.click}">
	      <input type="hidden" id="sdate" name="sdate" value="${DATA.sdate}">
	<%-- <c:if test="${DATA.file.get(0).bino ne 0}">
	   <c:forEach var="data" items="${DATA.file}"> 
	      <input type="hidden" name="bino" value="${data.bino}">
	      <input type="hidden" name="oriname" value="${data.oriname}">
	      <input type="hidden" name="savename" value="${data.savename}">
	   </c:forEach> 
	</c:if>--%>
	   

<%-- <form method="POST" action="/no4/board/boardEdit.no4" id="frm" name="frm">
		<input type="hidden" name="bno" value="${DATA.bno}">
	</form> --%>
	<div class="w3-col m3"><p></p></div>
		<div class="w3-col m7 w3-center">
		<h1 class="w3-center w3-orange w3-padding">BoardEdit</h1>
			<div class="w3-col"><h5>Here is BoardEdit Page</h5></div>
				<div class="w3-rwo w3-margin-top">
            		<div class="w3-col w3-padding w3-margin">

            			<br><br>
            		<!-- 글 제목 -->
	            		<span class="w3-left-align w3-col m2">제목 : </span>
	            		<div class="w3-border w3-left-align w3-col m6 w3-margin-bottom">
	            			<textarea id="title2" name="title">${DATA.title}</textarea>
            			</div>
 
            		<br><br><br>
            		<!-- 본문 내용 -->

            			<span class="w3-left-align w3-col m7 w3-margin-top">내용 : </span>
						<div class="w3-border w3-left-align w3-col m10 w3-margin-bottom">
	            			<div id="editmode">
	            			<textarea  class="w3-row" id="body2" name="body">${DATA.body}</textarea></div>
	            			</div>
	            		</div>
            		
            		<div class="w3-right-align w3-margin-top">
                		<div class="w3-button w3-red" id="editend">수정완료</div>
                		<div class="w3-button w3-red" id="cancel">취소</div>
                	</div>
            		</div>
	</div>
	</form>
</body>
</html>