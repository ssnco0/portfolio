<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>하단 부분</title>
<%--   <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css"> --%>
	<script src="${contextPath}/resources/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/rollmain.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.easing.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/common.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.smooth-scroll.min.js" type="text/javascript"></script>
  <style>
    p {
     font-size:20px;
/*       text-align:center; */
    }
  </style>
</head>
<body>
<footer>
		<div class="foot_area box_inner">
			<ul class="foot_list clear">
				<li><a href="javascript:;">이용약관</a></li>
				<li><a href="javascript:;">개인정보취급방침</a></li>
				<li><a href="#" onclick="$('#man_pop').css('height',$(document).height());$('#man_pop').show();">관리자로그인</a></li>
			</ul>
			<h2>Local Mileage Management</h2>
            <p class="addr">대전광역시 서구 둔산동 둔산서로 17 양호빌딩 6층<span class="gubun">/</span>        
				<span class="br_line">대표전화 <span class="space0">02-1234-5678</span> <span class="gubun">/</span>        
					<span class="br_line">E-mail : <span class="space0"> Lmmadmin@LMM.com</span></span>
				</span>
			</p>
			<p class="copy box_inner">Copyright(c) LMM all right reserved</p>
			<ul class="snslink clear">
				<li><a href="javascript:;">blog</a></li>
				<li><a href="javascript:;">facebook</a></li>
				<li><a href="javascript:;">instargram</a></li>
			</ul>
		</div>
	</footer>
	<!-- 가맹점 비밀번호 찾기 팝업창  -->
<form class="popup_base join_pop" id="man_pop" method="post"  action="${contextPath}/admin/login.do">
	<div class="pop_content">
		<p class="btn_xpop"><a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a></p>
			<ul class="pop_list">
				<li>
					<h2 class="tit_pop">관리자 로그인</h2>
			  			<div >
			   			<p><label>아이디</label>
							<input class="w3-input" type="text" id="manId" name="manId" ></p>
						<p><label>비밀번호</label>
							<input class="w3-input" type="password" id="manPassword" name="manPassword" ></p>
						<p class="w3-center">
							<button type="submit" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인</button>
							</p>
					</div>	
				</li>
			</ul>
	</div>
</form><!--/팝업창 -->
</body>
</html>