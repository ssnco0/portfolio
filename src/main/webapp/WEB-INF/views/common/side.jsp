<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%	request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드 메뉴</title>

</head>
<body>
	<c:choose>
	<c:when test="${memberInfo != null}">
	
	<div class="sidemenu_area">
                <div id="subMenu">
                    <ul>
                        <li>
                            <a href="${contextPath}/mypage/myDetailInfo.do" id="left0" class="lnb">내 정보</a>
                        </li>
                        <li>
                            <a href="#" id="left1" class="lnb">마일리지 조회</a>
                            <ul class="depth2">
                                <li><a href="${contextPath}/mileage/stackMileages.do">- 적립 마일리지</a></li>
                                <li><a href="${contextPath}/mileage/useMileages.do">- 사용 마일리지</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="${contextPath}/cupon/cusCuponList.do" id="left3" class="lnb">쿠폰함</a>
                            <ul class="depth2">
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
	
	</c:when>
	<c:when test="${storeInfo != null}">
		<div class="sidemenu_area">
                <div id="subMenu">
                    <ul>
                        <li>
                            <a href="${contextPath}/mypage/myStorePage.do" id="left0" class="lnb"> 가맹점 정보</a>
                        </li>
                        <li>
                            <a href="${contextPath}/payment/payment.do" id="left1" class="lnb"> 결제 처리</a>
                        </li>
                         <li>
                            <a href="${contextPath}/payment/listPayments.do" id="left1" class="lnb"> 환불 처리</a>
                        </li>
                        <li>
                            <a href="${contextPath}/cupon/listCupons.do" id="left3" class="lnb">쿠폰 관리</a>
                        
                        </li>
                    </ul>
                </div>
            </div>
	
	</c:when>
	
	</c:choose>
<script type="text/javascript">
    $(function(){
       $('ul.depth2').hide();
        $('.lnb').click(function(){
            if($(this).hasClass('on') == false){
                $('.lnb').each(function(){
                    if($(this).hasClass('on')){
                        $(this).removeClass('on');
                        $(this).next('.depth2').slideUp();
                    }  
                });
                $(this).addClass('on');
                $(this).next('.depth2').slideDown();
            }else{
                $(this).removeClass('on');
                $(this).next('.depth2').slideUp();
            }
        });
        
    });
</script>
</body>
</html>