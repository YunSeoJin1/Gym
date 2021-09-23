<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../sidebar.jsp"%>
<%@include file="../loginside.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		type: 'GET',
		headers: {
			Accept: "application/json; charset=utf-8",
			"Content-type": "application/json; charset=utf-8"
		},
		url: 'getWeightRecord',
		success: function(result) {
			// 최신 버전의 구글 코어차트 패키지 로드해준다.
			google.charts.load('current', {'packages':['corechart']});
			
			// 차트API가 로드완료했을 때 실행할 콜벡함수 선언
			google.charts.setOnLoadCallback(function() {
				drawChart(result);
			});
		},
		error: function() {
			alert("Chart drawing error!");
		}
	});
	
	function drawChart(result) {
		// 차트 그리는데 사용할 데이터 객체 생성
		var data = new google.visualization.DataTable();
		
		data.addColumn("number", "weight");
		data.addColumn("Date", "indate");
		
		// 콘트롤러에서 json타입으로 전달된 데이터를 
		// 자바스크립트의 배열로 저장
		var dataArray = [];
		$.each(result, function(i, obj){
			dataArray.push([obj.weight, obj.indate]);
		})
		
		// data객체에 dataArray의 내용을 저장
		data.addRows(dataArray);
		
		// 파이차트 그리기
		var piechart_options = {
			title: '날자별 몸무게',
			width: 300,
			height: 300
		};
		
		var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
		
		piechart.draw(data, piechart_options);
		
		// 바차트 그리기
		var barchart_options = {
			title: '날짜별 몸무게',
			width: 300,
			height: 300
		}
		
		var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
		
		barchart.draw(data, barchart_options);
	}
	
	
});
</script>
<section>
<div align="center">
	<h1>체중 증가량 측정</h1>
	<table>
		<tr>
			<td><div id="piechart_div" style="border:1px solid #ccc"></div></td>
			<td><div id="barchart_div" style="border:1px solid #ccc"></div></td>
		</tr>
	</table>
	</div>

</section>

<%@include file="../footer.jsp" %>