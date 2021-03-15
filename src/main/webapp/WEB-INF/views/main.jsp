<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    

<html>
<head>
<title>Home</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${contextPath}/resources/layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
 <script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="${contextPath}/resources/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/rollmain.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.easing.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/common.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.smooth-scroll.min.js" type="text/javascript"></script>
</head>

</head>
<body id="top">
        <div class="main_rolling_pc">
            <div class="visualRoll">
                <ul class="viewImgList">
                    <li class="imglist0">
                        <div class="roll_content">
                            <a href="${contextPath}/main.do">
                            <img src="${contextPath}/resources/image/img_slidecontents04.png" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!"></a>
                        </div>
                    </li>
                    <li class="imglist1">
                        <div class="roll_content">
                            <a href="${contextPath}/main.do">
                            <img src="${contextPath}/resources/image/img_slidecontents04.png" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!"></a>
                        </div>
                    </li>
                    <li class="imglist2">
                        <div class="roll_content">
                            <a href="${contextPath}/main.do">
                            <img src="${contextPath}/resources/image/img_slidecontents04.png" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!"></a>
                        </div>
                    </li>
                </ul>

                <div class="rollbtnArea">
                    <ul class="rollingbtn">
                        <li class="seq butt0"><a href="#butt"><img src="${contextPath}/resources/image/btn_rollbutt_on.png" alt="1번" /></a></li>
                        <li class="seq butt1"><a href="#butt"><img src="${contextPath}/resources/image/btn_rollbutt_off.png" alt="2번" /></a></li>
                        <li class="seq butt2"><a href="#butt"><img src="${contextPath}/resources/image/btn_rollbutt_off.png" alt="3번" /></a></li>
                        <li class="rollstop"><a href="#" class="stop"><img src="${contextPath}/resources/image/btn_roll_stop.png" alt="멈춤" /></a></li>
                        <li class="rollplay"><a href="#" class="play"><img src="${contextPath}/resources/image/btn_roll_play.png" alt="재생" /></a></li>
                    </ul>
                </div><!-- //rollbtnArea -->

            </div><!-- //visualRoll -->
        </div><!-- //main_rolling_pc -->
        
        <div class="main_rolling_mobile">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <a href="javascript:;"><img src="${contextPath}/resources/image/mainslide_mob01.jpg" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!" /></a>
                    </div>
                    <div class="swiper-slide">
                        <a href="javascript:;"><img src="${contextPath}/resources/image/mainslide_mob02.jpg" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!" /></a>
                    </div>
                    <div class="swiper-slide">
                        <a href="javascript:;"><img src="${contextPath}/resources/image/mainslide_mob03.jpg" alt="우리 동네에서 포인트 쌓기!지역도 살리고 혜택도 받자!" /></a>
                    </div>
                </div>						
                <div class="swiper-pagination"></div>
                
            </div><!--//swiper-container-->
        </div><!--//main_rolling_mobile -->
	
			
		<!-- Top Background Image Wrapper -->
		<%-- <div class="bgded overlay" style="background-image:url('${contextPath}/resources/images/demo/backgrounds/01.png');"> 
		
		  <div id="pageintro" class="hoc clear"> 
		    <article>
		      <h3 class="heading">Local Mileage Management</h3>
		      <p>지역 경제도 살리고 혜택도 받자</p>
		    </article>
		  </div>
		</div> --%>
		<!-- Top Background Image Wrapper -->
	
	
		<!-- about_area -->
		<div class="about_area">
			<h2>가맹점 소개</h2>
			<div class="about_box">
				<ul class="place_list box_inner clear">
					<li><a href="${contextPath}/intro/viewArticle.do?articleNO=7">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace01.jpg" alt="가맹점 소개 게시글  1" />
							<h3>aka</h3>
							<p class="txt">저희 아카카페는 포토갤러리를 겸한 카페로서 맛있는 차와 함께 사진작가님들의 멋진 사진도 감상할수있는 카페입니다.</p>
							<span class="view">소개글로 이동</span></a>
					</li>
					<li><a href="${contextPath}//intro/viewArticle.do?articleNO=8">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace02.jpg" alt="가맹점 소개 게시글  2" />
							<h3>이디야</h3>
							<p class="txt">안녕하세요. 카페 이디야 입니다. 예쁜 인테리어와 커피맛을 보장합니다.</p>
							<span class="view">소개글로 이동</span></a>
					</li>
					<li><a href="${contextPath}/intro/viewArticle.do?articleNO=9">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace03.jpg" alt="가맹점 소개 게시글  3" />
							<h3>삼디야</h3>
							<p class="txt"> 고객님들께 건강한 먹거리를 제공하기 위해 당일 준비한 재료로 신선한 샌드위치와 음료를 준비 하고 있습니다</p>
							<span class="view">소개글로 이동</span></a>
					</li>
					<li><a href="${contextPath}/intro/viewArticle.do?articleNO=10">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace04.jpg" alt="가맹점 소개 게시글  4" />
							<h3>사디야</h3>
							<p class="txt">인생마카롱, 달지 않은 수제마카롱, 예쁜 고퀄리티 마카롱 있습니다.</p>
							<span class="view">소개글로 이동</span></a>
					</li>
					<li><a href="${contextPath}/intro/viewArticle.do?articleNO=11">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace05.jpg" alt="가맹점 소개 게시글  5" />
							<h3>오디야</h3>
							<p class="txt"> 저희만의 추출법과 차법을 지켜 매일 정성스레 나갑니다 •좋은 재료와 수제 유기농 시럽으로 건 강하고 풍부한 맛을 추구합니다</p>
							<span class="view">소개글로 이동</span></a>
					</li>
					<li><a href="${contextPath}/intro/viewArticle.do?articleNO=12">
							<img class="img_topplace" src="${contextPath}/resources/image/img_topplace06.jpg" alt="가맹점 소개 게시글  6" />
							<h3>여기야</h3>
							<p class="txt"> 갈마동 동산아파트 앞 카페 여기야입니다 네이버 바로주문 가능합니다^^</p>
							<span class="view">소개글로 이동</span></a>
					</li>
				</ul>
			</div>
			<p class="about-control">
                <span class="prev"><img src="${contextPath}/resources/image/left-arrow.png" /></span>
                <span class="next"><img src="${contextPath}/resources/image/right-arrow.png" /></span>
            </p>
		</div>
		<!-- //about_area -->

		<!-- app_area -->
		<div class="appbbs_area">
			<div class="appbbs_box box_inner clear">
                <div class="bbs_line">
					<a href="${contextPath}/ntc/listArticles.do"><h3>Notice</h3></a>
					<ul class="notice_recent">
						<li><a href="${contextPath}/ntc/viewArticle.do?articleNO=1">각 가맹점 점주 유의사항</a></li>
						<li><a href="${contextPath}/ntc/viewArticle.do?articleNO=2">사이트 점검 관련 알림</a></li>
						<li><a href="${contextPath}/ntc/viewArticle.do?articleNO=3">가맹점 발행 쿠폰 승인 관련 공지</a></li>
						<li><a href="${contextPath}/ntc/viewArticle.do?articleNO=4">회원 자격 조건 변경사항</a></li>
						<li><a href="${contextPath}/ntc/viewArticle.do?articleNO=5">가맹점 쿠폰 할인액 관련 공지</a></li>
					</ul>
				</div>
				<div class="bbs_line">
					<a href="${contextPath}/qna/listArticles.do"><h3>Q&A</h3></a>
					<ul class="notice_recent">
						<li><a href="${contextPath}/qna/viewArticle.do?articleNO=1">마일리지 사용할 때 제한이 있나요?</a></li>
						<li><a href="${contextPath}/qna/viewArticle.do?articleNO=2">마일리지 사용해서 결제해도 마일리지 적립되나요?</a></li>
						<li><a href="${contextPath}/qna/viewArticle.do?articleNO=3">가족 마일리지 합산 가능한가요?</a></li>
						<li><a href="${contextPath}/qna/viewArticle.do?articleNO=4">내 마일리지 어디서 보나요?</a></li>
						<li><a href="${contextPath}/qna/viewArticle.do?articleNO=5">결제 에러가 나는데 이유가 뭔가요?</a></li>
					</ul>
				</div>
			</div>
		</div>
<!-- 가맹점소개 슬라이드 -->  
<script type="text/javascript">
    var slides = document.querySelector('.place_list'),
    slide = document.querySelectorAll('.place_list li'),
    currentIdx = 0,
    slideCount = slide.length,
    prevBtn = document.querySelector('.prev'),
    slideWidth = 360,
    slideMargin = 30,
    nextBtn = document.querySelector('.next');

    slides.style.width = (slideWidth + slideMargin)*slideCount - slideMargin + 'px';
    
    function moveSlide(num){
        slides.style.left = -num * slideWidth + 'px';
        currentIdx = num;
    }
    nextBtn.addEventListener('click', function(){
        if(currentIdx < slideCount -4){
            moveSlide(currentIdx + 1);
        }else{
            moveSlide(0);
        }
    });
    prevBtn.addEventListener('click', function(){
        if(currentIdx > 0){
            moveSlide(currentIdx - 1);
        }else{
            moveSlide(slideCount - 4);
        }
    });
</script>
<!-- 가맹점소개 슬라이드 -->
</body>
</html>
