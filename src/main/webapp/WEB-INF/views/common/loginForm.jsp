<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%  request.setCharacterEncoding("UTF-8"); %> 
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/loginEx.css">
 <script src="${contextPath}/resources/jquery/login.js" type="text/javascript"></script>
   
  <script>
  $(function() {
      $("#frmLogin2").hide(); 
      $("#userType2").click(function(){
    	  
             $("#frmLogin2").show();
             $("#frmLogin1").hide();
      });
          $("#userType3").click(function(){
        	
             $("#frmLogin1").show();
             $("#frmLogin2").hide();   
      }); 
  });
  </script>     
  <c:if test='${not empty message }'>
<script>
window.onload=function(){
  result();
}

function result(){
	alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>
</c:if> 

<style type="text/css">
.mybtn{
  width:150px;
  height:40px;
  padding:0;
  display:inline; 
  border-radius: 4px; 
  background: #212529;
  color: #fff;
  margin-top: 20px;
  border: solid 2px #212529; 
  transition: all 0.5s ease-in-out 0s;
}
.mybtn:hover .mybtn:focus {
  background: white;
  color: #212529;
  text-decoration: none;
}
.w3-container {width:382px; height:500px;}
.w3-button {margin:20px 20px 5px 20px;}
.w3-input {margin-left:10px; width:70%;}
#lgnbody.bodytext_area {background:url(${contextPath}/resources/image/img_topplace12.jpg); background-size:cover;}
/* #findBtn {width:150px; height:40px; color:#436274;}
#findBtn:hover {color:orange;} */
</style>
<title>로그인창</title>

</head>

<body>

<form id="frmLogin1" name="frmLogin" method="post" action="${contextPath}/member/login.do">
    <div id="container" id="layout0">
            <!-- bodytext_area -->
        <div class="bodytext_area box_inner" id="lgnbody">
            <div class="login_img">
            	<img alt="로그인 이미지" src="${contextPath}/resources/image/login_img.png">
            </div>
            
            <!-- login-wrap -->
            <div class="login_wrap">
              <ul class="login_list">                    
                        
               <!-- 로그인 테스트 시작 -->
                <div class="container-fluid" >
      
                  <div class="row">
                  
                     <div class="outBox">
                       <input type="radio" name="userType"  id="userType1" class="userType1" checked>
                            <label for="cusUser">사용자</label>
                  <input type="radio" name="userType"  id="userType2"class="userType2" >
                            <label for="store">가맹점</label>
                            <br><br><br>
                   
                        <div class="inputBox">
                           <input type="text" class="sampleId" name="cusId">
                           <label for="sampleId" class="lgn">아이디</label>
                        </div>
                            <br><br>
                           <div class="inputBox">
                              <input type="password" class="samplePw" name="cusPassword">
                              <label for="samplePW" class="lgn">비밀번호</label>
                           </div>  
                            <br><br>
                    <button type="submit" id="lgn_btn">로그인 </button> 
                      <div id="aBox">
                       <a id="aBox2" href="#" onclick="$('#id_pop').css('height',$(document).height());$('#id_pop').show();">아이디 찾기</a>
                       <a id="aBox1" href="#" onclick="$('#pw_pop').css('height',$(document).height());$('#pw_pop').show();">패스워드 찾기</a>
<!--                       	   <a id="aBox2" href="#" class="w3-right w3-button w3-hover-white" id="find_id_btn" >아이디 찾기</a> -->
                       <!--     <a id="aBox1" href="#" class="w3-right w3-button w3-hover-white" id="find_pw_btn">패스워드 찾기</a> -->
                           <a href="${contextPath}/member/memberForm.do">회원가입</a>
                           </div>                                 
                                
                      </div>
                                 
                  </div>
                             
                 </div>                   
                </ul>
                   
           </div>
       <!-- //login-wrap -->

        </div>
       <!-- //bodytext_area -->

   </div>
</form>

<form id="frmLogin2" name="frmLogin2" method="post"  action="${contextPath}/store/login.do">
    <div id="container" id="layout0">
            <!-- bodytext_area -->
        <div class="bodytext_area box_inner" id="lgnbody">
        	<div class="login_img">
            	<img alt="로그인 이미지" src="${contextPath}/resources/image/login_img.png">
            </div>
            <!-- login-wrap -->
            <div class="login_wrap">
               <ul class="login_list">                    
                        
                    <!-- 로그인 -->
                <div class="container-fluid" >
      
                  <div class="row">
                  
                     <div class="outBox">
                       <input type="radio" name="userType"  id="userType3" class="userType1">
                            <label for="cusUser">사용자</label>
                  <input type="radio" name="userType"  id="userType4"class="userType2" checked >
                            <label for="store">가맹점</label>
                            <br><br><br>
                            
                        <div class="inputBox ">
                           <input type="text" class="sampleId " name=stoId>
                           <label for="sampleId">아이디</label>
                        </div>
                            <br><br>
                           <div class="inputBox ">
                              <input type="password" class="samplePw" name="stoPassword">
                              <label for="samplePW">비밀번호</label>
                           </div>  
                               <br><br>
                    <button type="submit" id="lgn_btn">로그인 </button>                                
                           <div id="aBox">
                 		 <a id="aBox2" href="#" onclick="$('#id_pop').css('height',$(document).height());$('#id_pop').show();">아이디 찾기</a>
                       <a id="aBox1" href="#" onclick="$('#pw_pop1').css('height',$(document).height());$('#pw_pop1').show();">패스워드 찾기</a>
                           <a href="${contextPath}/store/storeForm.do">회원가입</a>
                           </div>     
                      </div>
                                 <!-- onclick="$('#id_pop').css('height',$(document).height());$('#id_pop').show();" -->
                  </div>
                             
                 </div>                   
                </ul>
                   
           </div>
       <!-- //login-wrap -->

        </div>
       <!-- //bodytext_area -->

   </div>
</form>
		<!--아이디 찾기 팝업창 공통 -->
		<div class="popup_base join_pop" id="id_pop">
			<div class="pop_content">
				<p class="btn_xpop">
					<a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a></p>
				<ul class="pop_list">
					<li>
						<h2 class="tit_pop">아이디 찾기</h2>
			
			<form id="frm" action="${contextPath}/member/findid.do" method="post">
				<p><label>이메일</label>
					<input class="w3-input" type="text" id="email" name="email" placeholder="이메일주소를 입력하세요" required></p>
				<p class="w3-center">
					<button type="button" onclick="document.getElementById('frm').submit();" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
<!-- 					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button></p> -->
			</form>	
			
			
	
					</li>
				</ul>
			</div>
		</div>
		<!--/팝업창 -->
		
<!--사용자 비밀번호 찾기 팝업창  -->
<div class="popup_base join_pop" id="pw_pop">
	<div class="pop_content">
		<p class="btn_xpop"><a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a></p>
			<ul class="pop_list">
				<li>
					<h2 class="tit_pop">비밀번호 찾기</h2>
			   			<form action="${contextPath}/member/findpw.do" method="post">
						<p><label>아이디</label>
							<input class="w3-input" type="text" id="id" name="cusId" placeholder="아이디를 입력하세요" required></p>
						<p><label>이메일</label>
							<input class="w3-input" type="text" id="email" name="cusEmail" placeholder="회원가입한 이메일주소를 입력하세요" required></p>
						<p class="w3-center">
							<button type="submit" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
<!-- 							<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button></p> -->
					</form>	
				</li>
			</ul>
	</div>
</div><!--/팝업창 -->

<!-- 가맹점 비밀번호 찾기 팝업창  -->
<div class="popup_base join_pop" id="pw_pop1">
	<div class="pop_content">
		<p class="btn_xpop"><a href="#" onclick="$(this).parent().parent().parent().hide();">닫기</a></p>
			<ul class="pop_list">
				<li>
					<h2 class="tit_pop">비밀번호 찾기</h2>
			   			<form action="${contextPath}/member/findpw.do" method="post">
						<p><label>아이디</label>
							<input class="w3-input" type="text" id="id" name="stoId" placeholder="아이디를 입력하세요" required></p>
						<p><label>이메일</label>
							<input class="w3-input" type="text" id="email" name="stoEmail" placeholder="회원가입한 이메일주소를 입력하세요" required></p>
						<p class="w3-center">
							<button type="submit" id="findBtn" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">찾기</button>
<!-- 							<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button></p> -->
					</form>	
				</li>
			</ul>
	</div>
</div><!--/팝업창 -->


	
<script>
	var loginBox = document.querySelector('.outBox');
	var loginIdInputBox = document.querySelector('.sampleId');
	var loginPwInputBox = document.querySelector('.samplePw');

	loginIdInputBox.addEventListener('keyup', function(){
    if(!loginIdInputBox.value == ''){
        loginBox.classList.add('existence');   
    }else{
       loginBox.classList.remove('existence');   
    	 }
	});
	 loginPwInputBox.addEventListener('keyup', function(){
    if(!loginPwInputBox.value == ''){
        loginBox.classList.add('existence');   
    }else{
        loginBox.classList.remove('existence');   
    	 }
	});	 
</script>
</body>
</html>
