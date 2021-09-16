<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="member/findpwd.js"></script>
<style type="text/css">
body{   
  background-color:#333;
  font-family: Verdana;
}
#wrap{     
	text-align: center;
  margin: auto;
  color: #fff;
  
}
h1 {
  font-family: "Times New Roman", Times, serif;
  font-size: 45px;
  color: #fff;
  font-weight: normal;
}

form {
			padding: 10px;
			margin-left: auto;
			margin-right: auto;
			border: 2px solid #fff;
			text-align: center;
			font-weight: bold;
		}
input[type=button], input[type=submit] {
  float: right;
}
label {
  width: 100px;
}
</style>
<script type="text/javascript">
function idok(){
  self.close();
}

</script>
</head>
<body>
<div id="wrap">
  <h1>비밀번호 찾기 결과</h1>
  <form method=post name=formm id="pwd_form" style="margin-right:0" >
    User ID <input type=text name="id" value="${id}" >   
    <div id="result">   
      <c:if test="${message == 1}">
      <h2>비밀번호 변경</h2>
      	<label>비밀&nbsp;번호&nbsp;&nbsp;</label> 
        <input type="password"  name="pwd" id="pwd"><br> 
        <label>비밀번호 확인</label> 
        <input type="password"  name="pwdCheck" id="pwdcheck"><br> 
        <input type="button" value="확인" class="cancel" onclick="changePassword()">
      </c:if>
      <c:if test="${message==-1}">
             잘못된 사용자 정보입니다.
         <input type="button" value="확인" class="cancel" onclick="idok()">
      </c:if>
    </div>
    
  </form>
</div>  
</body>
</html>