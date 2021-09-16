



const togglebtn = document.querySelector('.navbar_tooglebtn');
const menu = document.querySelector('.navbar_menu');
const icons = document.querySelector('navbar_icons');

togglebtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
})

        function dumbell_save() {
        	var chk = confirm("등록 하시겠습니까?");
        	if(chk){
        	$("#boardWrite").attr("encoding", "multipart/form-data");
        	$("#boardWrite").attr("action", "admin_dumbell_write").submit();
        	}
        };
        function dumbell_update(deseq) {
        	var chk = confirm("수정 하시겠습니까?");
        	if(chk){
        	$("#boardWrite").attr("encoding", "multipart/form-data");
        	$("#boardWrite").attr("action", "admin_dumbell_update?deseq="+deseq).submit();
        	}
        };
