<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="admin/admin.js"></script>
<link rel="stylesheet" href="css/admin.css" > 
</head>
<body>
	<div id="adminwrap">
		<div onclick="location.href='index'" style="cursor:pointer">
		<h1>홈화면</h1>
		</div>
		<div class="admin">
		<header>
			<h2>관리자 로그인 페이지</h2>
		</header>

		<form action="admin_login" method="POST">
			<div class="input-box">
				<input id="admin_id" type="text" name="admin_id" placeholder="아이디">
				<label for="admin_id">아이디</label>
			</div>

			<div class="input-box">
				<input id="admin_pwd" type="password" name="admin_pwd" placeholder="비밀번호">
				<label for="admin_pwd">비밀번호</label>
			</div>

			<input type="submit" value="로그인">
		</form>
		</div>
	</div>
</body>
</html>
