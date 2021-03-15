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

<script src="${contextPath}/resources/jquery/memberForm.js"type="text/javascript"></script>

</head>
<body>
	<form method="post">
		<div id="container">
			<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
						<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">마이페이지<span class="path">/</span> 가맹점 정보	</p>

				</div>
				</div>
			</div>
			<!-- location_area -->
			<!-- bodytext_area -->
			<div class="bodytext_area box_inner">
			<div id="inner1">
				<!-- appForm -->
				<form action="#" class="appForm">
					<fieldset>
						<div id="innerdiv">
							<ul class="app_list">
								<li class="clear">
								<label for="stoId" class="tit_lbl pilsoo_item ">아이디</label>
									<div class="app_content">
										<input type="text" class="" id="stoId" name="stoId"	value="${storeInfo.stoId }" disabled />
									</div><br>
									</li>
								<li class="clear">
								<label for="stoPassword" class="tit_lbl">비밀번호</label>
									<div class="app_content">
										<input type="password" name="stoPassword" id="pwd1" class="form-control" value="${storeInfo.stoPassword }" disabled/><br>									
									</div></li><br>
								<li class="clear">
								<label for="name_lbl"class="tit_lbl pilsoo_item">가맹점명</label>
									<div class="app_content">
										<input type="text" name="stoName" class="" id="name_lbl"value="${storeInfo.stoName }" disabled /> <br>
									</div></li><br>
								<li class="clear">
								<label for="buiNum_lbl"class="tit_lbl pilsoo_item">사업자번호</label>
									<div class="app_content">
										<input type="tel" name="stoBuiNum" class=""	id="buiNum_lbl" value="${storeInfo.stoBuiNum }" disabled />
									</div></li><br>
								<li class="clear"><label for="phone_lbl"class="tit_lbl pilsoo_item">휴대폰 번호</label>
									<div class="app_content">
										<input type="tel" class="" id="phone_lbl" name="stoPhone"value="${storeInfo.stoPhone }" disabled/>
									</div></li><br>
								<li class="clear">
								<label for="email_lbl"class="tit_lbl pilsoo_item">이메일</label>
									<div class="app_content email_area">
										<input type="text" name="stoEmail" class="" id="email_lbl"value="${storeInfo.stoEmail }" disabled/>
									</div></li><br>
								<li class="clear">
								<label for="sample4_postcode"class="tit_lbl pilsoo_item">주소</label><br> 
									<input type="text" id="sample4_postcode1" name="stoLocNum"value="지역번호&nbsp;&nbsp;&nbsp;${storeInfo.stoLocNum }"disabled> 
									<input type="text" name="stoAdress" id="sample4_roadAddress_1" value="${storeInfo.stoAdress }">
									</li><br>
									<%-- 	<li class="clear">
								<label for="stoSignDate"class="tit_lbl pilsoo_item">가입 날짜</label>
									<div class="app_content">
										<input type="text" class="" id="stoSignDate" name="stoSignDate"value="${storeInfo.stoSignDate }" readonly/>
									</div></li><br> --%>
						
							</ul>
						</div>
						<!-- innerdiv 끝 -->
				
					<p class="btn_line txt_right" id="mod_1"><a href="#" class="btn_bbs" onclick="$('#popup_mod').css('height',$(document).height());$('#popup_mod').show();" >수정하기</a></p>
						<!-- 	<p class="btn_line"><a href="#"  class="btnsize1" onclick="$('#popup_mod').css('height',$(document).height());$('#popup_mod').show();" >수정하기</a> -->
					</fieldset>
				</form>
				<!-- //appForm -->
			</div>
			<!-- //bodytext_area -->
		</div>
		</div>
		<!-- 팝업창 -->
	<!-- 	<form class="popup_base join_pop" id="popup_mod" > -->
	<div class="popup_base join_pop" id="popup_mod">
			<div class="pop_content">
				<p class="btn_xpop">
					<a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a>
				</p>
				<ul class="pop_list">
					<li>
						<h2 class="tit_pop">비밀번호 확인</h2>
		<div>
				<p><label>비밀번호</label>
					<input class="w3-input" type="password" id="pw1" name="stoPassword" value="${storeInfo.stoPassword }"  ></p>
				<p><label>비밀번호 확인</label>
					<input class="w3-input" type="password" id="pw2" name="stoPassword1"  ></p>
				<div id="pw-success">일치</div>
				<div id="pw-danger">불일치</div>
		</div>
						<div class="pop_txt">
							<a href="${contextPath}/mypage/modStoInfo.do"><button type="submit"class="btnsize3 btn3" id="btnpwchk" >확인</button></a>
						</div>
					</li>
				</ul>
			</div>
	</div>
		<!--/팝업창 -->
	</form>
</body>
</html>
