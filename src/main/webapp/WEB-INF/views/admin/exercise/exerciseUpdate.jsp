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
                          <input class="btn" type="button" name="btn_total" value="전체 목록 " onClick="location.href='admin_exercise_list'">
                          
                      </td>
                    </tr>
                  </table>
                <div class="board-write">
                    <form id="boardWrite" method="POST" enctype="multipart/form-data">
                        <div class="boardWrite">
                            <h1>Exercise Update</h1>
                            <table>
                                <tr>
                                    <th>운동이름</th>
                                    <td><input type="text" name="dex_name" id="dex_name" size="50" maxlength="100" value="Exercise Name"></td>
                                </tr>
                                <tr>
                                    <th>운동 부위</th>
                                    <td><input type="text" name="dex_part" id="dex_part" size="50" maxlength="100" value="Exercise part"></td>
                                </tr>
                                <tr>
                                    <th>운동 설명</th>
                                    <td><textarea name="dex_desciription" id="dex_description" rows="8" cols="70">description</textarea></td>
                                </tr>
                                <tr>
                                    <th>운동 이미지</th>
                                    <td>
                                        <input type="file" name="exercise_image" id="exercise_image"  accept="image/*" onchange="setThumbnail(event);">
                                        <div id="image_container"></div>
                                    </td>
                                </tr>
                            
                                
                                        
                                   
                            </table>
                                        <input class="board-btn" type="button" value="수정" onclick="location.href='admin_exercise_update'">           
                                        <input class="board-btn" type="button" value="취소" onClick="location.href='admin_exercise_list'">
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