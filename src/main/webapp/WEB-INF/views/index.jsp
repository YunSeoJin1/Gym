<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@include file="sidebar.jsp" %>
<%@include file="loginside.jsp" %>



<c:choose>
	<c:when test="${empty sessionScope.loginUser}">
		<div id="wrapper">
		  <div id="info">
		    <div id="info-content">
		      <h1>Multi Exercise Imfomation <strong>Just do it</strong></h1>
		      <p>Project GYM</p>
		    </div>
		   </div>
		</div>
	</c:when>
	<c:otherwise>
			<div id="wrapper">
		  <div id="info">
		    <div id="info-content">
				 <section class="about">
		           <div class="inner">
		               <div class="about-content">
		                    <div class="photo">
		                        <img src="./images/01.목 스트레칭.gif">
		                    </div>
		                   <div class="desc">
		                       <h2>Stretching Category</h2>
		                       
		                      <a href="body_stretching">이동하기</a>
		                   </div>
		               </div>
		           </div>
		       </section>
		       <section class="about">
		           <div class="inner">
		               <div class="about-content">
		                    <div class="photo">
		                        <img src="./exerciseimg/dumbell(chest).jpg">
		                    </div>
		                   <div class="desc">
		                       <h2>Exercise Category</h2>
		                       <p>
		                           Exercise Infomation
		                       </p>
		                      <a href="dumbell">이동하기</a>
		                   </div>
		               </div>
		           </div>
		       </section>
       	  </div>
		   </div>
		</div>
	</c:otherwise>
</c:choose>
<%@include file="footer.jsp" %>


