/*
 * 아이디, 이름, 비밀번호를 입력하여 비밀번호 찾기 요청
 */
function findPassword() {
	
	if ($("#id2").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#id2").focus();
	} else if ($("#name2").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#name2").focus();
	} else if ($("#email2").val() == "") {
		alert("이메일을 입력해 주세요!");
		$("#email2").focus();
	} else {
		$("#findPW").attr("action", "find_password").submit();
	}
}

/*
 * 암호 변경을 위한 입력 검증 및 요청처리
 */
function changePassword() {
	
	if ($("#pwd").val() == "") {
		alert("암호를 입력해 주세요!");
		$("#pwd").focus();
	} else if ($("#pwd").val() != $("#pwdcheck").val()) {
		alert("암호가 일치하지 않습니다!");
		$("#pwd").focus();
	} else {
		$("#pwd_form").attr("action", "change_password").submit();
	}
}
