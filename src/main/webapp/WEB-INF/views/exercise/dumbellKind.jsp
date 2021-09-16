<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../sidebar.jsp" %>
<%@include file="../loginside.jsp" %>
<link rel="stylesheet" href="css/dumbell.css" >
<section class="Exercise">
        <div class="inner">
            <div class="Exercise-content">
            <h1>Exercise List</h1>	
            <table class="board-title">
              <tr>
                <td width="642">
                    Exercise Name
                    <input type="text" name="key" id="key">
                    <input class="btn" type="button" name="btn_search" value="검색" onClick="location.href='index'">
                    <input class="btn" type="button" name="btn_total" value="전체보기 " onclick="location.href='dumbell_list'">
                	<br><br><input class="btn" type="button" value="가슴" onclick="location.href='dumbell_part?dex_part=1'">
                	<input class="btn" type="button" value="등" onclick="location.href='dumbell_part?dex_part=2'">
                	<input class="btn" type="button" value="이두" onclick="location.href='dumbell_part?dex_part=3'">
                	<input class="btn" type="button" value="삼두" onclick="location.href='dumbell_part?dex_part=4'">
                	<input class="btn" type="button" value="복근" onclick="location.href='dumbell_part?dex_part=5'">
                	<input class="btn" type="button" value="하체" onclick="location.href='dumbell_part?dex_part=6'">
                </td>
              </tr>
              		<!-- 임시 링크로 테스트 -->

            </table>
            <c:forEach items="${dumbellKindList}" var="dumbellVO">
            <table class="board-List">
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                </tr>
                <tr>
                    <td>${dumbellVO.deseq}</td>
                    <td><a href="dumbell_view?deseq=${dumbellVO.deseq}">
                    	<img src="images/${dumbellVO.dex_img}"></a></td>
                    <td>${dumbellVO.dex_name}</td>
                    <td>${dumbellVO.dex_part}</td>
                    <td><input type="checkbox" value="${dumbellVO.dex_ckbox}"></td>
                </tr>
            </table>
            </c:forEach>
            </div>
        </div>
    </section>

<%@include file="../footer.jsp" %>
