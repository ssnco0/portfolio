<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="${contextPath}/resources/jquery/jquery-1.11.3.min.js"type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/rollmain.js"type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/jquery.easing.js"	type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/common.js"	type="text/javascript"></script>
<script	src="${contextPath}/resources/jquery/jquery.smooth-scroll.min.js"type="text/javascript"></script>


</head>
<body>

	<header id="header">
		<div class="header_area box_inner clear">
			<h1>
				<a href="${contextPath}/main.do">LMM</a>
			</h1>
			<p class="openMOgnb">
				<a href="#"><b class="hdd">메뉴열기</b> <span></span><span></span><span></span></a>
			</p>
			<!-- header_cont -->
			<div class="header_cont">
				<ul class="util clear">

					<c:choose>
						<c:when test="${isLogOn == true  && memberInfo!= null}">
							<li><a href="${contextPath}/userpage.do">${memberInfo.cusId}님!&nbsp;환영합니다. </a>&nbsp;&nbsp; <a
								href="${contextPath}/member/logout.do">로그아웃</a></li>
						</c:when>
						<c:when test="${isLogOn == true  && storeInfo!= null}">
							<li><a href="${contextPath}/userpage.do">${storeInfo.stoId} 님!&nbsp;환영합니다. </a>&nbsp;&nbsp; <a
								href="${contextPath}/store/logout.do">로그아웃</a></li>
						</c:when>
						<c:when test="${isLogOn == true  && managerInfo!= null}">
							<li><a href="#"> 관리자님! &nbsp;환영합니다. </a>&nbsp;&nbsp; <a
								href="${contextPath}/admin/logout.do">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath}/member/loginForm.do">로그인</a></li>
							<li>
								<a href="#"	onclick="$('#join_pop2').css('height',$(document).height());$('#join_pop2').show();">회원가입</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
				<nav>
					<ul class="gnb clear">
						<li><a href="${contextPath}/ntc/listArticles.do" class="openAll1">공지사항</a></li>
						<li><a href="${contextPath}/qna/listArticles.do" class="openAll2">Q&A</a></li>
						<li><a href="${contextPath}/intro/listArticles.do" class="openAll3">가맹점소개</a></li>
						<li>
						<c:choose>
							<c:when test="${isLogOn == true  && memberInfo!= null}">
								<a href="${contextPath}/mypage/myDetailInfo.do"	class="openAll4">마이페이지</a>
									<div class="gnb_depth gnb_depth2_4">
										<ul class="submenu_list">
											<li><a href="${contextPath}/mypage/myDetailInfo.do">내 정보</a></li>
											<li><a href="${contextPath}/mileage/stackMileages.do">마일리지 조회</a></li>
											<li><a href="${contextPath}/cupon/cusCuponList.do">쿠폰함</a></li>
										</ul>
									</div>
							</c:when>
							<c:when test="${isLogOn == true  && storeInfo!= null}">
								<a href="${contextPath}/mypage/myStorePage.do" class="openAll4">마이페이지</a>
									<div class="gnb_depth gnb_depth2_4">
										<ul class="submenu_list">
											<li><a href="${contextPath}/mypage/myStorePage.do">가맹점 정보</a></li>
											<li><a href="${contextPath}/payment/payment.do">결제 관리</a></li>
											<li><a href="${contextPath}/cupon/listCupons.do">쿠폰 관리</a></li>									
									</div>
							</c:when>
						<c:otherwise>
								<a href="${contextPath}/member/loginForm.do" class="openAll4">마이페이지</a>
									<div class="gnb_depth gnb_depth2_4">
										<ul class="submenu_list">
										</ul>
									</div>
						</c:otherwise>
					</c:choose>
							</li>
					</ul>
				</nav>
				<p class="closePop">
					<a href="javascript:;">닫기</a>
				</p>
			</div>
			<!-- //header_cont -->
		</div>
<!-- 팝업창  -->
		<div class="popup_base join_pop" id="join_pop2">
			<div class="pop_content">
				<p class="btn_xpop">
					<a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a>
				</p>
				<ul class="pop_list">
					<li>
						<h2 class="tit_pop">가입 사용자 유형 선택</h2>
						<div class="pop_txt">
							<button class="btnsize3 btn3">
								<a href="${contextPath}/member/memberForm.do">사용자 회원가입</a>
							</button>
							<button class="btnsize3">
								<a href="${contextPath}/store/storeForm.do">가맹점 회원가입</a>
							</button>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!--/팝업창 -->
	</header>

</body>
</html>