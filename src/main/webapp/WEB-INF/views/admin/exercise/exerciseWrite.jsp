<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../adminHeader.jsp" %>
 <section class="Exercise">
        <div class="inner">
            <div class="Exercise-content">
                <table class="board-title">
                    <tr>
                      <td width="642">
                          Exercise Name
                          <input type="text" name="key" id="key">
                          <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
                          <input class="btn" type="button" name="btn_total" value="전체 목록 " onClick="go_total()">
                          
                      </td>
                    </tr>
                  </table>
                <div class="board-write">
                    <form id="boardWrite" action="write_form" method="POST" enctype="multipart/form-data">
                        <div class="boardWrite">
                            <h1>Exercise Insert</h1>
                            <table>
                                <tr>
                                    <th>운동이름</th>
                                    <td><input type="text" name="dex_name" id="dex_name" size="50" maxlength="100" value="Exercise Name"></td>
                                </tr>
                                <tr>
                                    <th>운동 부위</th>
                                    <td>카테고리</td>
                                </tr>
                                <tr>
                                    <th>운동 설명</th>
                                    <td><textarea name="dex_desciription" id="dex_description" rows="8" cols="70">description</textarea></td>
                                </tr>
                                <tr>
                                    <th>운동 이미지</th>
                                    <td>
                                        <input type="file" name="profile" id="dex_img"  accept="image/*" onchange="setThumbnail(event);">
                                        <div id="image_container"></div>
                                    </td>
                                </tr>
                            
                                
                                        
                                   
                            </table>
                                        <input class="board-btn" type="button" value="등록" onClick="go_save()">           
                                        <input class="board-btn" type="button" value="취소" onClick="go_mov()">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <script>
        function setThumbnail(event){
           
           var reader = new FileReader();
           
           reader.onload = function(event) {
               
               var img = document.createElement("img");
                  img.setAttribute("src", event.target.result);
               document.querySelector("div#image_container").appendChild(img);
           };
       
       reader.readAsDataURL(event.target.files[0]); }
   </script>
<%@include file="../adminFooter.jsp"%>