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

</head>

<body>
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				Local <span class="in">Mileage</span> Management
			</h2>
			<p class="location">
				쿠폰함<span class="path">></span> 
			</p>

		</div>
	</div>
	<!-- location_area -->



		<div class="bodytext_area box_inner body_area">
	<div id="inner1">
	
			<table class="bbsListTbl mesg">
			<thead>
				<tr height="10" align="center" bgcolor="lightgreen">
					<th>No</th>
					<th>할인액</th>
					<th>내용</th>
					<th>사용일</th>
					<!-- <th>쿠폰상태</th> -->
					
				</tr>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${cuscuponList == NULL}"> <!-- 몰라  -->
						<tr height="10">
							<td colspan="3">
								<p align="center">
									<b><span style="font-size: 15pt;">너 쿠폰 없어</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="cupon" items="${cuscuponList}" varStatus="usNum">
							<tr align="center">
								<td >${usNum.count}</td>
								<td >${cupon.cupDiscount}</td>
									<td >${cupon.cupAdvContents}</td>
								<td >${cupon.cupUseDate}</td>
	<%-- 							<td >${cupon.cupKind}</td> --%>
							
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>

</div>

</body>
</html>