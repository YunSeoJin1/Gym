/**
 * 
 */

// 약관동의 여부 확인
function go_next(){
   if($('.agree')[0].checked == true) {   /*동의 함으로 체크 되어 있으면'회원가입'을 요청함*/
      $('#join').attr('action', 'join_form').submit();
   }else if ($('.agree')[1].checked == true) {
      alert("약관에 동의 해주셔야 합니다.");
   }
}


function go_save(){
   if($("#id").val() == ""){
      alert("아이디를 입력 해주세요!");
      $("#id").focus();
   }else if($("#id").val() != $("#reid").val()){
      alert("아이디 중복 체크를 해주세요 !");
      $("#id").focus();
   }else if($("#pwd").val() == ""){
      alert("비밀 번호를 입력해주세요!")
      $("#pwd").focus();
   }else if($("#pwd").val() != $("#pwd2").val()){
      alert("비밀 번호가 일치하지 않습니다!")
      $("#pwd2").focus();
   }else if($("#name").val() == ""){
      alert("이름을 입력해 주세요!");
   }else{
      $("#join").attr("action","join").submit();
   }
}


function idcheck(){
   if($("#id").val() == ""){
      alert("아이디를 입력해주세요!");
      $("#id").focus();
      return;
   }
   // 아이디 중복 체크를 위한 윈도우 오픈
   var url="id_check_form?id=" + $("#id").val();
   
   window.open(url,"_blank_1",
         "tollbar=no, menubar=no, scrollbars=no, resizable=yes, width=400, height=300");
   
}

function idok(){
   $("#theform").attr("action", "id_check_confirmed").submit();
}