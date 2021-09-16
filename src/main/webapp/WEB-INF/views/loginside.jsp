<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<link rel="stylesheet" href="css/loginside.css" >  

 <input type="checkbox" id="menuicon">
    <label for="menuicon">
        <span></span>
        <span></span>
        <span></span>
    </label>
    <c:choose>
	    <c:when test="${empty sessionScope.loginUser}">
		    <div class="sidebar2">
		        <div id="login">
		            <section class="login-form">
		                <h2>LOGO DESIGN</h2>
		                    <form action="login" method="post">
		                        <div class="int-area">
		                            <input type="text" name="id" id ="id"
		                            autocomplete="off" required>
		                            <label for ="id">User ID</label>
		                        </div>
		                        <div class="int-area">
		                            <input type="password" name="pwd" id ="pwd"
		                            autocomplete="off" required>
		                            <label for="pwd">User Password</label>
		                        </div>
		                        <div class="btn-area">
		                            <button id="btn" type="submit">LOGIN</button>
		                        </div>
		                        <div class="btn-area">
		                  			<button id="btn" type="button" value="회원가입" class="cancel" onclick="location='contract'">
		                   			회원 가입</button>
		                   		</div>
		                    </form>
		                    
		                    <div class="caption">
								<a href="#" onclick="window.open('find_id_form', '_blank_1','toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300, top=300, left=300');">아이디 찾기</a>   
		                    </div>
		                    <div class="caption">
		                        <a href="#" onclick="window.open('find_pwd_form', '_blank_1','toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=400, top=300, left=300');">비밀번호 찾기</a>              
		                    </div>
		            </section>
		        </div>
		    </div>
	    </c:when>
	    <c:otherwise>
	    	<div class="sidebar3">
		    	 <div class="card">
			        <div class="ds-top"></div>
			        <div class="avatar-holder">
			          <img src="profile_img/${sessionScope.loginUser.profile_img}">
			        </div>
			        <div class="name">
			          <p>${sessionScope.loginUser.name}</p>
			        </div>
			       
			        <div class="ds-info">
			          <div class="ds pens">
			            <h6 title="Number of pens created by the user">Pens <i class="fas fa-edit"></i></h6>
			            <p>29</p>
			          </div>
			          <div class="ds projects">
			            <h6 title="Number of projects created by the user">Projects <i class="fas fa-project-diagram"></i></h6>
			            <p>0</p>
			          </div>
			          <div class="ds posts">
			            <h6 title="Number of posts">Posts <i class="fas fa-comments"></i></h6>
			            <p>0</p>
			          </div>
			        </div>
			        <div class="ds-skill">
			          <h6>체질량<i class="fa fa-code" aria-hidden="true"></i></h6>
			          <div class="skill html">
			            <h6><i class="fab fa-html5"></i> 신장 </h6>
			            <div class="bar bar-html">
			              <p>${sessionScope.loginUser.height} cm</p>
			            </div>
			          </div>
			          <div class="skill css">
			            <h6><i class="fab fa-css3-alt"></i>몸무게</h6>
			            <div class="bar bar-css">
			              <p>${sessionScope.loginUser.weight} kg</p>
			            </div>
			          </div>
			          <div class="skill javascript">
			            <h6><i class="fab fa-js"></i>bmi</h6>
			            <div class=bar2>
			              <meter min="0" max="40" low="18.5" high="24" optimum="22" value="${sessionScope.loginUser.weight/((sessionScope.loginUser.height/100)*(sessionScope.loginUser.height/100))}"></meter>
			              <p><fmt:formatNumber value="${sessionScope.loginUser.weight/((sessionScope.loginUser.height/100)*(sessionScope.loginUser.height/100))}" pattern="#,#00.0#"/></p>
			            </div>
			          </div>
			        </div>
			      </div>
			        <div class="caption2">
		                  <a href="logout">로그아웃</a>
		            </div>
		      </div>
	    </c:otherwise>
    </c:choose>
    
    
    <script>
        let id = $('#id');
        let pwd = $('#pwd');
        let btn = $('#btn');

        $(btn).on('click', function() {
            if($(id).val == ""){
                $(id).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning')
                },1500);
            }
            else if ($(pwd).val== ""){
                $(pwd).next('label').addClass('warning');
                setTimeout(function() {
                    $('label').removeClass('warning')
                },1500);
            }
        });
        
    </script>
