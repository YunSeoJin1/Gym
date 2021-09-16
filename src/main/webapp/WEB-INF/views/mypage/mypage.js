/**
 * 
 */
function info_save(){
	if ($("#pwd").val()=="") {
		alert("비밀번호를 입력하세요!");
		$("#pwd").focus();
	} else if ($("#pwd2").val()==""){
		alert("비밀번호 확인을 입력해주세요!");
		$("#pwd2").focus();
		
	}
	alert("회원정보 변경 완료");
	$("#info").attr("encoding","multipart/form-data");
	$("#info").attr("action","info").submit();
	
	
}

function weight_rec(){
	let today = new date();
	if($("#indate").val()=="") {
		$("#indate").val()== today;
		alert("오늘 날짜가 입력 되었습니다!");
	}
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