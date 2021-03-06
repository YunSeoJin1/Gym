<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../sidebar.jsp" %>
<%@include file="../loginside.jsp" %>
<link rel="stylesheet" href="css/dumbell.css" >
<div class="board_list_wrap">
	<form name="frm" id="dumbell_form" method ="post">
            <table class="board_list">
                <div class="title">
                    <h2>Dumbell Exercise</h2>
                </div>
                <div class="searchbar">
                    <input type="text" placeholder="검색어 입력">
                    <button>검색</button>
                </div>
                <div class="savebtn_area">
                    <input class="savebtn" type="button" value="저장하기">
                </div>
                    <thead>
                        <tr>
                            <th style="width: 10%;">번호</th>
                            <th style="width: 150px;">사진</th>
                            <th style="width: 15%;">제목</th>
                            <th style="width: 15%;">
                            <select style="width: 100%; text-align: center;">
                                <option>-----부위-----</option>
                                <option value="1">-----가슴-----</option>
                                <option value="2">-----&nbsp;&nbsp;등&nbsp;&nbsp;-----</option>
                                <option value="3">-----이두-----</option>
                                <option value="4">-----삼두-----</option>
                                <option value="5">-----복근-----</option>
                                <option value="6">-----하체-----</option>
                            </select>
                            </th>
                            <th style="width: 30%;">설명</th>
                            <th style="width: 20%;">리스트 저장</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:choose>
	                    <c:when test="${dumbListSize<=0}">
							    <tr>
							      <td width="100%" colspan="7" align="center" height="23">
							        등록된 운동이 없습니다.
							      </td>      
							    </tr>
						</c:when>
						<c:otherwise>
		                    <c:forEach items="${dumbellList}" var="DumbellVO">
		                        <tr>
		                            <td>${DumbellVO.deseq}</td>
		                            <td><img src="exerciseimg/${DumbellVO.dex_img}"></td>
		                            <td>${DumbellVO.dex_name}</td>
		                            <td>${DumbellVO.dex_part}</td>
		                            <td>${DumbellVO.dex_description}</td>
		                            <td><input type="checkbox" value="${DumbellVO.dex_ckbox}"></td>
		                        </tr>
		                   	</c:forEach>
		                   		<tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	                   	</c:otherwise>
	                   	</c:choose>
	                   	
                   </tbody>
        	</table>
    	</form> 
    	<%--@include file="../page_area.jsp"-- --%>	
    </div>  

<%@include file="../footer.jsp" %>
