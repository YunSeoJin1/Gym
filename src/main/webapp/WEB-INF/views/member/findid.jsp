<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="member/findid.js"></script>
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
</head>
<body>
	<div id="wrap">
	  	<h1>아이디 찾기</h1>
	  	<br>
		<form name="findId" id="findId" action="find_id" method="get">
		<table>
		<tr>
			<td align="right"><label> 이&nbsp;&nbsp;름</label></td>
			<td><input type="text" name="name" id="name" value=""></td>
		</tr>	
		<tr>
			<td align="right"><label> 이메일</label></td>
			<td><input type="text" name="email" id="email" value=""></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input type="button" value="아이디 찾기" onclick="findMemberId()"></td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>