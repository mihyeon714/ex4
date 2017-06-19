<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>noticeView</title>
</head>
<body>
	<h2>noticeView PAGE / 현재위치 /ex1/notice</h2>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>NUM</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.num}</td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.hit}</td>
			</tr>
		</tbody>
		<thead>
			<tr>
				<th colspan="4">CONTENTS</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4">${dto.contents}</td>
			</tr>
		</tbody>
	</table>
	
	
	<a href="./noticeList">리스트보기</a> <br/>
	<a href="./noticeUpdate?num=${dto.num}">수정</a>
	<a href="./noticeDelete?num=${dto.num}">삭제</a>
</body>
</html>