<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css" >  
<link rel="stylesheet" href="css/sidebar.css"> 


</head>
<body>
<div id="sidebarMenu">

    <aside class="sidebar">
           <header>
          <a href="index">Menu</a>
        </header>
      <nav class="sidebar-nav">
        <ul>
          <li>
            <a href="#"><i class="ion-bag"></i> <span>mypage</span></a>
            <ul class="nav-flyout">
              <li>
                <a href="info_form"><i class="ion-ios-color-filter-outline"></i>내 정보수정</a>
              </li>
              <li>
                <a href="weight_record"><i class="ion-ios-clock-outline"></i>체중 측정</a>
              </li>
              <li>
                <a href="#"><i class="ion-ios-chatboxes-outline"></i>변화 그래프</a>
              </li>
              
            </ul>
          </li>
          <li>
            <a href="body_stretching"><i class="ion-ios-settings"></i> <span class="">Stretching</span></a>
            
          </li>
          <li>
            <a href="dumbell_list"><i class="ion-ios-briefcase-outline"></i> <span class="">Exercise</span></a>
           </li>
          <li>
            <a href="#"><i class="ion-ios-navigate-outline"></i> <span class="">Best Traning course</span></a>
            <ul class="nav-flyout">
              <li>
                <a href="#"><i class="ion-ios-flame-outline"></i>Burn</a>
              </li>
              <li>
                <a href="#"><i class="ion-ios-lightbulb-outline"></i>Bulbs</a>
              </li>
              <li>
                <a href="#"><i class="ion-ios-location-outline"></i>Where You</a>
              </li>
              <li>
                <a href="#"><i class="ion-ios-locked-outline"></i>On Lock</a>
              </li>
               <li>
                <a href="#"><i class="ion-ios-navigate-outline"></i>Ghostface</a>
              </li>
            </ul>
          </li>
          <li>
            <a href="admin"><i class="ion-ios-medical-outline"></i> <span class="">about</span></a>
          </li>
        </ul>
      </nav>
    </aside>

</div>
