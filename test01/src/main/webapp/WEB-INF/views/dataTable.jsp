<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/cls/css/w3.css" />
<link rel="stylesheet" href="/cls/css/user.css" />
<script type="text/javascript" src="/cls/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('seby').DataTable();
	});
</script>
<style>

</style>
</head>
<body>
		<table id="seby" class="">
		<thead>
			<tr><th>No</th></tr>
		</thead>
		<tbody>
			<tr><td>1</td><td>서울</td></tr>
			<tr><td>2</td><td>경기도</td></tr>
			<tr><td>3</td><td>충청남도</td></tr>
			<tr><td>4</td><td>충청북도</td></tr>
			<tr><td>5</td><td>전라남도</td></tr>
			<tr><td>6</td><td>전라북도</td></tr>
			<tr><td>7</td><td>경상남도</td></tr>
			<tr><td>8</td><td>경상북도</td></tr>
			<tr><td>9</td><td>강원도</td></tr>
			<tr><td>10</td><td>제주도</td></tr>
			<tr><td>99</td><td>해외</td></tr>
		</tbody>
	</table>
</body>
</html>