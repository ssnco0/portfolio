<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<style>
.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 30px;
}
</style>
<meta charset="UTF-8">
<script src="${contextPath}/resources/jquery/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<title>글목록창</title>
<script>
	$(function() {
		var t = $("#mil").val();
		var total_cost = 0;
		for (var i = 1; i < t.length; i++) {

			if (t[i].value > 0) {
				total_cost = new Number(total_cost) + new Number(t[i].value);
			}
		}
		$("#total_cost").val(total_cost);
	});
</script>
</head>

<body>
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				Local <span class="in">Mileage</span> Management
			</h2>
			<p class="location">
				마일리지 조회 <span class="path">></span> 사용 마일리지
			</p>

		</div>
	</div>
	<!-- location_area -->

	<div class="bodytext_area box_inner body_area">
		<div id="inner1">
			
				<label for="tot">보유 마일리지</label><br>
				<div class="tot">
					<input type="text" id="cusTotMil" class="form-control"
						value="${memberInfo.cusTotMil}" readonly />
				</div>
			
		
		<!--//tot_out  -->
		<br><br>
			<table class="bbsListTbl mesg">
				<thead>
					<tr height="10" align="center" bgcolor="lightgreen">
						<th>No</th>
						<th>사용</th>
						<th>사용일</th>
					</tr>
				</thead>
				<tbody>
					<%-- <c:choose>
						  <c:when test="${useMil == null }" >
							<!-- 몰라  -->
							<tr height="10">
								<td colspan="3">
									<p align="center">
										<b><span style="font-size: 15pt;">마일리지 사용 내역이 없습니다.</span></b>
									</p>
								</td>
							</tr>
						</c:when>
						  <c:when test="${useMil !=null }" > --%>
							<c:forEach var="useMil" items="${useMil}" varStatus="usNum">
								<tr align="center">
									<td>${usNum.count}</td>
									<td class="tit_notice"><a href="javascript:;">${useMil.payUseMil}</a></td>
									<td>${useMil.payDate}</td>
								</tr>
							</c:forEach>
<%-- 						</c:when>
					</c:choose> --%>
				</tbody>
			</table>
		
</div>
	</div>

</body>
</html>