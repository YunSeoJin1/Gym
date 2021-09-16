<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="member/findpwd.js"></script>
<style type="text/css">
		body{
			background-color: #333;
			font-family: Verdana;
			color : white;
			
		}
		#wrap{
			margin: auto;
			text-align: center;
			
		}
		table {
			padding: 15px;
			margin-left: auto;
			margin-right: auto;
			border: 1px solid #000;
			text-align: center;
			font-weight: bold;
		}
		
	</style>
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<form name="findPW" id="findPW">
	<table>
	<tr>
		<td align="right"><label> 아이디</label></td>
		<td><input type="text" name="id" id="id2" value=""></td>
	</tr>	
	<tr>
		<td align="right"><label> 이름</label></td>
		<td><input type="text" name="name" id="name2" value=""></td>
	</tr>	
	<tr>
		<td align="right"><label> 이메일</label></td>
		<td><input type="text" name="email" id="email2" value=""></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="button" value="비밀번호 찾기" onclick="findPassword()"></td>
	</tr>
	</table>
	</form>

</body>
</html>