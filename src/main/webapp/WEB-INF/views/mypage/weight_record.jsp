<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	  #bmi{
    	  	top:200px;
           	background-color: #333;
            margin: auto;
            padding: auto;
            width: 500px;
            height: 500px;
            border: 1px solid black;
            color: white;
            
        }
        #bmi h2{
            text-align: center;
        }
        #bmi_view{
            margin: auto;
            margin-top: 10%;
            padding: 10px;
            border: 1px solid black;
            width: 50%;
            height: 50%;
        }
        .bmi-area{
            padding: 5px;
            
        }
        .bmi-area input{
            width: 60%;
        }
        .bmi-area[button]{
            width: 100%;
        }
        button,button::after{
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            -o-transition: all 0.3s;
            transition: all 0.3s;
        }
        button {
            background: none;
            border: 3px solid #fff;
            border-radius: 5px;
            color: #fff;
            display: block;
            font-size: 1.6em;
            font-weight: bold;
            margin: 1em auto;
            padding: 1em 3em;
            position: relative;
            text-transform: uppercase;
        }

        button::before,
        button::after {
            background: #fff;
            content: '';
            position: absolute;
             z-index: -1;
        }  
       
        button:hover{
            color: skyblue;
        }
        #btn1::after{
            height: 0;
            left: 0;
            top: 0;
            width: 100%;
        }
        #btn1:hover:after{
            height: 100%;
        }
       
    </style>


<%@include file="../sidebar.jsp"%>
<%@include file="../loginside.jsp" %>

	<div id="bmi">
            <h2>체중 측정</h2>
             <form id="record" action="record" method="get">
             <div id="bmi_view">
             	<div class="bmi-area">
             		<label>유저</label>
                    <input type="text" id="id" value="${sessionScope.loginUser.id}"><br>
             	</div>
                <div class="bmi-area">
                    <label>체중</label>
                    <input type="number" step="0.1" id="weight"> Kg<br>
                </div>
                <div class="bmi-area">
                    <label>날짜</label>
                    <input type="date" id="indate"><br>
                   
                </div>
                <div class="bmi-btn-area">
                    <button id="btn1" type="submit">확인</button>
                </div>
            </div>
            </form>
        </div>
<script type="text/javascript" src="mypage/mypage.js"></script>		
<%@include file="../footer.jsp"%>