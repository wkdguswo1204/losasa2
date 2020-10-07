<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<link rel="stylesheet" href="/no4/css/w3.css" />
<link rel="stylesheet" href="/no4/css/user.css" />
<script type="text/javascript" src="/no4/js/jquery-3.5.0.min.js"></script>
<!-- <script type="text/javascript" src="/no4/js/board.js"></script> -->
<script type="text/javascript">
$(document).ready(function(){	
	$('#write').click(function(){
		$(location).attr('href', '/no4/board/boardWrite.no4');
	});
	$('.content').click(function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		$('#frm').submit();
	});
});
</script>

</head>
<body>
<form method="POST" id="frm" name="frm" action="/no4/board/boardDetail.no4">
	<input type="hidden" name="bno" id="bno">
	<div class="w3-col m3"	><p></p></div>
		<div class="w3-col m6 w3-center">
		<h1 class="w3-center w3-orange w3-padding">Board</h1>
			<div class="w3-col"><h5>Here is Board Page</h5></div>
		<div class="w3-rwo w3-margin-top">
            <div class="w3-col w3-padding w3-right-align w3-margin">
                <div class="w3-button w3-red" id="write">글쓰기</div>
            </div>

            <table class="w3-col w3-table-all w3-hoverable">
              <thead>
                <tr class="w3-light-grey content">
                  <th>글번호</th>
                  <th id="btn">제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>조회수</th>
                </tr>
              </thead>
              <c:forEach var="data" items="${LIST}">
	              <tr class="w3-text-gray content" id="${data.bno}">
	                <td>${data.bno}</td>
	                <td>${data.title}</td>
	                <td>${data.id}</td>
	                <td>${data.sdate}</td>
	                <td>${data.click}</td>
	              </tr>
              </c:forEach>
              </table>
         </div>
	</div>
</form>
</body>
</html>