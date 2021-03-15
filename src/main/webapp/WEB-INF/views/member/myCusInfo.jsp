<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="result" value="${param.result }" />
<%  request.setCharacterEncoding("UTF-8");%>    
<html>
<head>
<title>Home</title>
 <script src="${contextPath}/resources/jquery/memberForm.js" type="text/javascript"></script>

</head>

<body>
		<form method="post" >
		<div id="container">
			<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">마이페이지<span class="path">/</span> 내 정보	</p>

				</div>
			</div>
			<!-- location_area -->

			<!-- bodytext_area -->
			<div class="bodytext_area box_inner">
			<div id="inner1">
				<!-- appForm -->
				<form action="#" class="appForm">
					<fieldset >
						<div id="innerdiv">
				<!-- 	<p class="info_pilsoo pilsoo_item">필수입력</p> -->
						<ul class="app_list">
							<li class="clear"><label for="id_lbl"	class="tit_lbl pilsoo_item ">아이디</label><br>
								<div class="app_content">
									<input type="text" class="" id="cusId" name="cusId" value="${memberInfo.cusId }"  disabled>				
								</div> <br>
							</li>
								
							<li class="clear">
							<label for="pwd1" class="tit_lbl">비밀번호</label> 
							<div class="app_content">
    							<input type="password" name="cusPassword" id="pwd1" class="form-control" value="${memberInfo.cusPassword }"   disabled/>  <br> <br>
   		 						</div>
								
							<li class="clear"><label for="name_lbl"	class="tit_lbl pilsoo_item">이름</label>
								<div class="app_content ">
									<input type="text" name="cusName" class="" id="name_lbl" value="${memberInfo.cusName }" disabled/> <br>
									<div id="name_check"></div>
								</div>
							</li><br>
							
							<li class="clear">
								<label for="birth_lbl"	class="tit_lbl pilsoo_item">생년월일</label>
								<div class="app_content">
									<input type="tel" name="cusBirth" class="" id="birth_lbl" value="${memberInfo.cusBirth }"disabled> <br>
								</div>
							</li><br>
							
							<li class="clear">
								<label for="phone_lbl"	class="tit_lbl pilsoo_item">휴대폰 번호</label>
								<div class="app_content">
									<input type="tel" class="" id="phone_lbl" name="cusPhone" value="${memberInfo.cusPhone }"  disabled/>
									</div>
							</li><br>

							<li class="clear"><label for="email_lbl"class="tit_lbl pilsoo_item">이메일</label>
								<div class="app_content email_area">
									<input type="text" name="cusEmail" class="" id="email_lbl" value="${memberInfo.cusEmail }"disabled/>	

								</div>
							</li><br>
							
							<li class="clear"><label for="email_lbl"class="tit_lbl pilsoo_item">보유 마일리지</label>
								<div class="app_content email_area">
									<input type="text" name="cusTotMil" class="" id="email_lbl" value="${memberInfo.cusTotMil }"disabled/>	

								</div>
							</li><br>
							
							<li class="clear"
							><label for="email_lbl"class="tit_lbl pilsoo_item">이메일 수신 여부</label> &nbsp; &nbsp; &nbsp; &nbsp;
								<c:choose >
					    			<c:when test="${memberInfo.cusAdv =='1' }">
									<input type='radio' name='cusAdv' value='1'  checked/>동의 &nbsp;&nbsp;
 									 <input type='radio' name='cusAdv' value='0' />거부
								  </c:when>
					  			  <c:otherwise>
					   				 <input type='radio' name='cusAdv' value='1' />동의 &nbsp;&nbsp;
 									 <input type='radio' name='cusAdv' value='0' checked/>거부
					    			</c:otherwise>
					  				 </c:choose>
							</li><br><br>

							<li class="clear"><label for="sample4_postcode"class="tit_lbl pilsoo_item">주소</label><br>
							<input type="text" name="CusAdress" id="sample4_roadAddress" class="D_adr"value="${memberInfo.cusAdress }"disabled>
							
							</li>	
						</ul>
						</div>
						<!-- <p class="btn_line"><a href="#"  class="btnsize1" onclick="$('#popup_mod').css('height',$(document).height());$('#popup_mod').show();" >
						<button type="button">수정하기</button></a></p> -->
							<p class="btn_line txt_right" id="mod_1"><a href="#" class="btn_bbs" onclick="$('#popup_mod').css('height',$(document).height());$('#popup_mod').show();" >수정하기</a></p>
					</fieldset>
					
				</form>
				
				<!-- //appForm -->	
			</div>
			<!-- //bodytext_area -->
		</div>
		</div>
		<!-- 팝업창  -->
<!-- 		<form class="popup_base join_pop" id="popup_mod" > -->
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
					<input class="w3-input" type="password" id="pw1" name="cusPassword" value="${memberInfo.cusPassword }"  ></p>
				<p><label>비밀번호 확인</label>
					<input class="w3-input" type="password" id="pw2" name="cusPassword1"  ></p>
				<div id="pw-success">일치</div>
				<div id="pw-danger">불일치</div>
		</div>
						<div class="pop_txt">
							<a href="${contextPath}/mypage/modCusInfo.do"><button class="btnsize3 btn3" id="btnpwchk" >확인</button></a>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!--/팝업창 -->
	</form>
</body>
</html>
