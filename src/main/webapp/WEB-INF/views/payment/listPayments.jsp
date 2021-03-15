<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>결제 정보 출력창</title>
</head>
<body>
<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">결제 관리 <span class="path">></span> 환불	</p>

				</div>
			</div>
			<!-- location_area -->

	<div class="bodytext_area box_inner body_area">	
	<div id="inner1">
<table class="bbsListTbl mesg">
	<thead>
    <tr align="center"   bgcolor="lightgreen">
      <th><b>No</b></th>
      <th><b>금액</b></th>
      <th><b>최종 금액</b></th>
      <th><b>결제일</b></th>
      <th><b>사용</b></th>
      <th><b>적립</b></th>
<!--       <th><b>처리유형</b></th> -->
      <th><b>가맹점ID</b></th>
      <th><b>사용자ID</b></th>
      <th><b>쿠폰ID</b></th>     
      <th><b>환불</b></th>
   </tr>
   </thead>
   <tbody>
 <c:forEach var="payment" items="${paymentsList}" varStatus="payNo" >     
   <tr align="center">
      <td>${payNo.count}</td>
      <td>${payment.payAco}</td>
      <td>${payment.payReal}</td>
      <td>${payment.payDate}</td>
      <td>${payment.payUseMil}</td>
      <td>${payment.milStack}</td>
<%--       <td>${payment.payType}</td> --%>
      <td>${payment.stoId}</td>
      <td>${payment.cusId}</td> <!-- <p class="btn_line txt_right"><a href="#" class="btn_bbs">목록</a></p> -->
      <td>${payment.cupId}</td>
      <td class="btn_line txt_right"><a href="${contextPath}/payment/refundProcess.do?payNum=${payment.payNum}&cupId=${payment.cupId}&cusId=${payment.cusId}
      											&payUseMil=${payment.payUseMil}&milStack=${payment.milStack}" class="btn_bbs">환불</a></td>
    </tr>
  </c:forEach>   
  </tbody>
</table>
</div>
</div>
</body>
</html>
