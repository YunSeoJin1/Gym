<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../adminHeader.jsp" %>

<section class="Exercise">
        <div class="inner">
            <div class="Exercise-content">
            <h1>Exercise List</h1>	
            <table class="board-title">
              <tr>
                <td width="642">
                    Exercise Name
                    <input type="text" name="key" id="key">
                    <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
                    <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
                    <input class="btn" type="button" name="btn_write" value="운동 등록" onClick="go_wrt()">
                </td>
              </tr>
            </table>
            <table class="board-List">
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                    
                </tr>
                <tr>
                    <td>01</td>
                    <td><img src="./images/PT 자세.jpg"></td>
                    <td>스쿼트</td>
                    <td>하체</td>
                    <td>스쿼트 자세</td>
                </tr>
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                    
                </tr>
                <tr>
                    <td>01</td>
                    <td><img src="./images/PT 자세.jpg"></td>
                    <td>스쿼트</td>
                    <td>하체</td>
                    <td>스쿼트 자세</td>
                </tr>
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                    
                </tr>
                <tr>
                    <td>01</td>
                    <td><img src="./images/PT 자세.jpg"></td>
                    <td>스쿼트</td>
                    <td>하체</td>
                    <td>스쿼트 자세</td>
                </tr>
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                    
                </tr>
                <tr>
                    <td>01</td>
                    <td><img src="./images/PT 자세.jpg"></td>
                    <td>스쿼트</td>
                    <td>하체</td>
                    <td>스쿼트 자세</td>
                </tr>
                <tr>
                    <th>번호</th>
                    <th>사진</th>
                    <th>운동 이름</th>
                    <th>부위</th>
                    <th>설명</th>
                    
                </tr>
                <tr>
                    <td>01</td>
                    <td><img src="./images/PT 자세.jpg"></td>
                    <td>스쿼트</td>
                    <td>하체</td>
                    <td>스쿼트 자세</td>
                </tr>
                
                
                <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
    
            </table>
            
            </div>
        </div>
    </section>
<%@include file="../adminFooter.jsp"%>