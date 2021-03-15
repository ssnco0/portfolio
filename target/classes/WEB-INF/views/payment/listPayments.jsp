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
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>결제번호</b></td>
      <td><b>결제금액</b></td>
      <td><b>실 결제금액</b></td>
      <td><b>결제일자</b></td>
      <td><b>사용 마일리지</b></td>
      <td ><b>처리유형</b></td>
      <td><b>가맹점아이디</b></td>
      <td><b>사용자아이디</b></td>
      <td><b>쿠폰아이디</b></td>     
      <td><b>삭제</b></td>
   </tr>
   
 <c:forEach var="payment" items="${paymentsList}" >     
   <tr align="center">
      <td>${payment.payNum}</td>
      <td>${payment.payAco}</td>
      <td>${payment.payReal}</td>
      <td>${payment.payDate}</td>
      <td>${payment.payUseMil}</td>
      <td>${payment.payType}</td>
      <td>${payment.stoId}</td>
      <td>${payment.cusId}</td>
      <td>${payment.cupId}</td>
      <td><a href="${contextPath}/payment/removePayment.do?id=${payment.payNum }">환불하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/payment/paymentForm.do"><h1 style="text-align:center">결제하기</h1></a>
</body>
</html>
