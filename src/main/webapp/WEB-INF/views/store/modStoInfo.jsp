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
<title></title>

<script src="${contextPath}/resources/jquery/modMypage.js"type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }	

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script type="text/javascript">
		$(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "${contextPath}/main.do";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#stoPassword").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#stoPassword").focus();
					return false;
				}if ($("#stoPassword").val() != $("#stoPassword1").val()){
					alert("비밀번호가 일치하지 않습니다.")
					$("#stoPassword1").focus();
					return false;
				}
				if ($("#stoPassword").val() <4 || $("#stoPassword").val() >12) {
					alert("비밀번호 제한이 맞지 않습니다.")
					$("#stoPassword").focus();
					return false;
				}
				
			});

		})
	</script>
	<script>
 //휴대폰 검사
function fn_overlappedPh(){
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;// 휴대폰 번호 정규식
    var _ph=$("#phone_lbl").val();
   	if(_ph==''){
    		$('#ph_check').text('휴대폰 번호를 입력해주세요 :)');
			$('#ph_check').css('color', 'red');
			$("#reg_submit").attr("disabled", true);
		return;
   	   }     
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/store/overlappedPh.do",
       dataType:"text",
       data: {phone:_ph},
       success:function (data,textStatus){   	 
    	  if(phoneJ.test(_ph)){
      		 $("#ph_check").text("");
   			 $("#reg_submit").attr("disabled", false);	 			 
    	     if(data=="false"){ 
        		 $("#ph_check").text("사용 가능한 휴대폰 번호입니다 :p");
        		 $("#ph_check").css("color", "red");
       	    	 $("#btnOverlappedPh").prop("disabled", true);
       	     	 $("#phone_lbl").prop("disabled", true);
     	   		 $("#_phone_lbl").val(_ph);
    	     }else{
            	 $("#ph_check").text("사용 중인 휴대폰 번호입니다 :p");
    			 $("#ph_check").css("color", "red");
    			 $("#reg_submit").attr("disabled", true);
    	     }
          }else{
        	 $("#ph_check").text("휴대폰 번호를 확인해주세요. :)");
			 $("#ph_check").css("color", "red");
			 $("#reg_submit").attr("disabled", true);
          } 
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");
       },
       complete:function(data,textStatus){
          //alert("작업을완료 했습니다");
       }
    });  //end ajax	 
 }
 
 
//이메일 중복
function fn_overlappedEm(){
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var _em=$("#email_lbl").val();
     	 if(_em==''){
    		$('#em_check').text('이메일를 입력해주세요 :)');
			$('#em_check').css('color', 'red');
			$("#reg_submit").attr("disabled", true);
		return;
   	   }     
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/store/overlappedEm.do",
       dataType:"text",
       data: {email:_em},
       success:function (data,textStatus){   	 
    	  if(mailJ.test(_em)){
      		 $("#em_check").text("");
   			 $("#reg_submit").attr("disabled", false);	 			 
    	     if(data=="false"){ 
        		 $("#em_check").text("사용 가능한 이메일입니다 :p");
        		 $("#em_check").css("color", "red");
       	    	 $("#btnOverlappedEm").prop("disabled", true);
       	    	 $("#email_lbl").prop("disabled", true); 
     	   		 $("#cusEmail").val(_em);
    	     }else{
            	 $("#em_check").text("사용 중인 이메일입니다 :p");
    			 $("#em_check").css("color", "red");
    			 $("#reg_submit").attr("disabled", true);
    	     }
          }else{
        	 $("#em_check").text("이메일을 확인해주세요 :)");
			 $("#em_check").css("color", "red");
			 $("#reg_submit").attr("disabled", true);
          } 
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");
       },
       complete:function(data,textStatus){
          //alert("작업을완료 했습니다");
       }
    });  //end ajax	 
 } 




</script>

</head>
<body>
	<form method="post" action="${contextPath}/mypage/modifyStoInfo.do" >
		<div id="container">
			<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">	마이페이지 <span class="path">></span> 가맹점 정보 수정</p>
				</div>
			</div>
			<!-- location_area -->
			<!-- bodytext_area -->
			<div class="bodytext_area box_inner">
			<div id="inner1">
				<!-- appForm -->
				<form action="${contextPath}/mypage/modifyStoInfo.do" class="appForm">
					<fieldset>
						<div id="innerdiv">
							<ul class="app_list">
								<li class="clear">
								<label for="stoId" class="tit_lbl pilsoo_item ">아이디</label>
									<div class="app_content">
										<input type="text" class="" id="stoId" name="stoId"	value="${storeInfo.stoId }" readonly />
									</div></li><br>
								<li class="clear"><label class="tit_lbl">비밀번호</label> 
									<div class="app_content">
    								<input type="password" name="stoPassword" id="stoPassword" class="form-control"  />  <br>
   		 						</div>
   								<label class="tit_lbl">비밀번호 확인</label> 
   									<div class="app_content">
   								 	<input type="password" name="stoPassword1" id="stoPassword1" class="form-control"  /><br>
   									</div> 
								</li> <br> 

								<li class="clear">
								<label for="name_lbl"class="tit_lbl pilsoo_item">가맹점명</label>
									<div class="app_content">
										<input type="text" name="stoName" class="" id="name_lbl"value="${storeInfo.stoName }" readonly /> <br>
									</div></li><br>
								<li class="clear">
								<label for="buiNum_lbl"class="tit_lbl pilsoo_item">사업자번호</label>
									<div class="app_content">
										<input type="tel" name="stoBuiNum" class=""	id="buiNum_lbl" value="${storeInfo.stoBuiNum }" readonly />
									</div></li><br>
								<li class="clear">
								<label for="phone_lbl"class="tit_lbl pilsoo_item">휴대폰 번호</label>
									<div class="app_content">
										<input type="tel" class="" id="phone_lbl" name="stoPhone"value="${storeInfo.stoPhone }" />
									</div></li><br>
								<li class="clear">
								<label for="email_lbl"class="tit_lbl pilsoo_item">이메일</label>
									<div class="app_content email_area">
										<input type="text" name="stoEmail" class="" id="email_lbl"value="${storeInfo.stoEmail }" />
									</div></li><br>
										<li class="clear">
							<label for="sample4_postcode"class="tit_lbl pilsoo_item">주소</label><br>							
							<input type="text" id="sample6_postcode" placeholder="우편번호">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" id="sample6_address"  name="stoAdress" class="D_adr"placeholder="주소"><br>
							<input type="hidden" id="sample6_detailAddress"placeholder="상세주소">
							<input type="hidden" id="sample6_extraAddress" placeholder="참고항목">
									<br></li>
								
							</ul>
						</div>
						<!-- innerdiv 끝 -->
						
						<p class="btn_line">
							<button type="submit"  class="btnsize1"id="submit" >수정하기</button>
							<button type="button"  class="btnsize2 .cencle"  >취소하기</button>
						</p>
					</fieldset>
				</form>
				<!-- //appForm -->
			</div>
			<!-- //bodytext_area -->
		</div>
		</div>

	</form>
</body>
</html>
