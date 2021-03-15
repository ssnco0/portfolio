<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="result" value="${param.result }" />
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<title>Home</title>

</head>
<body>
	<form method="post">
		<div id="container">
			<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
						<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">가맹점<span class="path">/</span> 가맹점 페이지	</p>

				</div>
				</div>
			</div>
			<!-- location_area -->
			<!-- bodytext_area -->
			<div class="bodytext_area box_inner">
				<!-- appForm -->
				<form action="#" class="appForm">
					<fieldset>
					
						<div id="innerdiv">
							<div id="stoimg">
							
							</div>
							<div id="">
							
							</div>
						</div>
						<!-- innerdiv 끝 -->
						
					
							<p class="btn_line"><a href="#"  class="btnsize1" onclick="$('#popup_mod').css('height',$(document).height());$('#popup_mod').show();" >수정하기</a>
					</fieldset>
				</form>
				<!-- //appForm -->
			</div>
			<!-- //bodytext_area -->
		</div>
		
	</form>
</body>
</html>
