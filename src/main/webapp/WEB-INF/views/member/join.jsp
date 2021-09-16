<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/join.css"> 

<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="member/member.js"></script>
<%@include file="../sidebar.jsp" %>

    <div id="join_view">
        <section class="join-form">
            <h2>회원가입</h2>
                <form id="join" action="join" method="post" name="formm" enctype="multipart/form-data">
                    <div class="join-area">
                        <input type="text" name="name" id ="name"
                        autocomplete="off" required>
                        <label for ="name">User Name</label>
                        
                    </div>
                    <div class="join-area">
                        <input type="text" name="id" id ="id" autocomplete="off" value="${id}" required >
                        <label for ="joinid">User ID</label>
                        <input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br>
                        <input type="hidden" name="reid" id="reid" value="${reid}">
                    </div>

                    <div class="join-area">
                        <input type="password" name="pwd" id ="pwd"
                        autocomplete="off" required>
                        <label for="pwd">User Password</label>
                    </div>
                    <div class="join-area">
                        <input type="password" name="pwd2" id ="pwd2"
                        autocomplete="off" required>
                        <label for="pwd2">User Password Check</label>
                    </div>
                    <div class="join-area">
                        <input type="email" name="email" id ="email"
                        autocomplete="off" required>
                        <label for ="email">Email</label>
                    </div>
                    <div class="join-area">
                        <input type="tel" name="phone" id ="phone"
                        autocomplete="off" onKeyup = "addHypen(this);" required>*숫자만 입력해주세요
                        <label for ="phone">Phone</label>
                    </div>
                     <div class="join-area">
                        <input type="number" name="height" id ="height"
                        autocomplete="off" required>
                        <label for ="height">height</label>
                    </div>
                     <div class="join-area">
                        <input type="number" name="weight" id ="weight"
                        autocomplete="off" required>
                        <label for ="height">weight</label>
                    </div>
                    <br>
                    <div class="join-area">
                    	
                    	<p>프로필 사진 : <p>
                        <input type="file" name="profile" id="profile_img"  accept="image/*" onchange="setThumbnail(event);">
						<div id="image_container"></div>
                    </div>
                    
                    <div class="btn-area">
                        <button id="btn" type="submit" onclick="go_save()"> 회원가입 </button>
                    </div>
                	<div class="btn-area">
                        <button id="btn" type="button" onclick="location.href='index.html';"> 홈화면</button>
                    </div>
                </form>
               
        </section>
    </div>
    
    <%@include file="../footer.jsp" %>
    <script>
    
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

