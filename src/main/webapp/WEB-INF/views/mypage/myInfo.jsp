<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../sidebar.jsp" %>
<%@include file="../loginside.jsp" %>
<script type="text/javascript" src="mypage/mypage.js"></script>
<link rel="stylesheet" href="css/info.css" > 
 	  <div id="info-div">
        <form id="info" action="info" method="post" enctype="multipart/form-data">
            <div id="info-title">
                <h2>회원 정보 수정</h2>
            </div>
            <div id="info-area">
                <input type="text" id="name" name="name" value="${memberVO.name}">
                <label>이름 :</label>
            </div>
            <div id="info-area">
                <input type="text" id="id" name="id" value="${memberVO.id}">
                <label>아이디 : </label>
            </div>
            <div id="info-area">
                <input type="password" id="pwd" name="pwd">
                <label>비밀번호 : </label>
            </div>
            <div id="info-area">
                <input type="password" id="pwd2" name="pwd2">
                <label>비밀번호 확인 : </label>
            </div>
            <div id="info-area">
                <input type="email" id="email" name="email" value="${memberVO.email}">
                <label>Email : </label>
            </div>
            <div id="info-area">
                <input type="text" id="phone" name="phone" value="${memberVO.phone}" onKeyup = "addHypen(this);">
                <label>Phone : </label>
            </div>
            <div class="info-area">
                <p>프로필 사진 : <p>
                <input type="file" name="profile" id="profile_img"  accept="image/*" onchange="setThumbnail(event);">
                <div id="image_container"></div>
                <div id="pro_img"><img src="profile_img/${memberVO.profile_img}"></div>
            </div>
            <div class="btn-area">
                <button id="btn" type="submit" onclick="info_save()"> 정보 수정 </button>
            
                <button id="btn" type="button" onclick="history.back();"> 취소 </button>
            </div>
        </form>
    </div>

    
<%@include file="../footer.jsp" %>
<script>
function info_save(){
	if ($("#pwd").val()=="") {
		alert("비밀번호를 입력하세요!");
		$("#pwd").focus();
	} else if ($("#pwd").val()==""){
		alert("비밀번호 확인을 입력해주세요!");
		$("#pwd2").focus();
		
	}
	alert("회원정보 변경 완료");
	$("#info").attr("encoding","multipart/form-data");
	$("#info").attr("action","info").submit();
}

function setThumbnail(event){
	
	var reader = new FileReader();
	
    reader.onload = function(event) {
    	
    	var img = document.createElement("img");
   		img.setAttribute("src", event.target.result);
    	document.querySelector("div#image_container").appendChild(img);
    };

reader.readAsDataURL(event.target.files[0]); }


function addHypen(obj) {
    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}
</script>
