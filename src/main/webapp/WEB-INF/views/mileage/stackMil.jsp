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
<title>글목록창</title>
</head>


<script>
	
</script>


<body>
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				Local <span class="in">Mileage</span> Management
			</h2>
			<p class="location">
				마이페이지 <span class="path">></span>적립 마일리지
			</p>

		</div>
	</div>
	<!-- location_area -->

	<div class="bodytext_area box_inner body_area">
		<div id="inner1">
		
		<label for="app_content">보유 마일리지</label><br>
		<div class="app_content">
			<input type="text" id="cusTotMil" class="form-control"
				value="${memberInfo.cusTotMil}" />
		</div>
		<br> <br>
		<table class="bbsListTbl mesg">
			<thead>
				<tr height="10" align="center" bgcolor="lightgreen">
					<th>No</th>
					<th>적립</th>
					<th>적립일</th>
				</tr>
			</thead>
			<tbody>
		<%-- 		<c:choose>
					  <c:when test="${stackMil ==null }" >
						<tr height="10">
							<td colspan="3">
								<p align="center">
									<b><span style="font-size: 15pt;">마일리지 적립 내역이 없습니다.</span></b>
								</p>
							</td>
						</tr>
					</c:when>
					  <c:when test="${stackMil !==null }" > --%>
						<c:forEach var="stackMil" items="${stackMil}" varStatus="stNum">
							<tr align="center">
								<td>${stNum.count }</td>
								<td class="tit_notice"><a href="javascript:;">${stackMil.milStack }</a>
								</td>
								<td>${stackMil.milDate }</td>
							</tr>
						</c:forEach>
		<%-- 			</c:when>>
				</c:choose> --%>
			</tbody>
		</table>
</div>
	</div>

</body>
</html>