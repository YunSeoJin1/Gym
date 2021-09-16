<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../adminHeader.jsp" %>
<section class="Exercise">
        <div class="inner">
            <div class="Exercise-content2">
				<h1>Exercise Detail</h1>
				<table>
					<tr>
						<th>이름</th>
						<td>${dumbellVO.deseq}</td>
					</tr>
					
					<tr>
						<th>이미지</th>
						<td><p><img style="width: 300px;" 
					src="images/${dumbellVO.dex_img}"></p></td>
					</tr>
					<tr>
						<th>운동 이름: </th>
						<td><p>${dumbellVO.dex_name} </p></td>
					
					</tr>
					<tr>
						<th>설명</th>
						<td><textarea rows="8" cols="40">${dumbellVO.dex_description}</textarea></td>
					<tr>

				</table>
				
				
				
					<input type="button" value="목록보기" class="btn"
						onclick="location.href='admin_dumbell_list'"> 
					<input type="button" value="수정하기" class="btn"
						onclick="location.href='admin_dumbell_update_form?deseq=${dumbellVO.deseq}'"> 
					<input type="button" value="삭제하기" class="btn"
						onclick="location.href='admin_dumbell_delete?deseq=${dumbellVO.deseq}'">
			</div>
     	</div>
</section>
<%@include file="../adminFooter.jsp"%>