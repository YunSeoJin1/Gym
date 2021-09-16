<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../adminHeader.jsp" %>
<div style="text-align: center; margin: 50px 0px;">
	상세보기 테스트
	
	<p>번호 : ${dumbellVO.deseq}</p>
	<p>사진: <img style="width: 500px;" 
		src="images/${dumbellVO.dex_img}"></p>
	<p>운동 이름: ${dumbellVO.dex_name} </p>
	<p>부위 : ${dumbellVO.dex_part}</p>
	<p>설명: ${dumbellVO.dex_description}</p>
	<br><br>
	
		<input type="button" value="목록보기" class="btn"
			onclick="location.href='admin_dumbell_list'"> 
		<input type="button" value="수정하기" class="btn"
			onclick="location.href='admin_dumbell_update_form?deseq=${dumbellVO.deseq}'"> 
		<input type="button" value="삭제하기" class="btn"
			onclick="location.href='admin_dumbell_delete?deseq=${dumbellVO.deseq}'">
</div>	
<%@include file="../adminFooter.jsp"%>