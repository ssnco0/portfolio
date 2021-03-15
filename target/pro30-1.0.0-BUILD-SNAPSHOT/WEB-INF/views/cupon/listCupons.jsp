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
<title>쿠폰 정보 출력창</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>쿠폰아이디</b></td>
      <td><b>QR코드번호</b></td>
      <td><b>쿠폰생성일</b></td>
      <td><b>할인액</b></td>
      <td><b>쿠폰사용일</b></td>
      <td ><b>쿠폰상태</b></td>
      <td><b>광고내용</b></td>
      <td><b>사용자아이디</b></td>
      <td><b>가맹점아이디</b></td>     
      <td><b>삭제</b></td>
   </tr>
   
 <c:forEach var="cupon" items="${cuponsList}" >     
   <tr align="center">
      <td>${cupon.cupId}</td>
      <td>${cupon.cupQrNo}</td>
      <td>${cupon.cupDate}</td>
      <td>${cupon.cupDiscount}</td>
      <td>${cupon.cupUseDate}</td>
      <td>${cupon.cupKind}</td>
      <td>${cupon.cupAdvContents}</td>
      <td>${cupon.cusId}</td>
      <td>${cupon.stoId}</td>
      <td><a href="${contextPath}/cupon/removeCupon.do?id=${cupon.cupId }">쿠폰 삭제</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/cupon/cuponForm.do"><h1 style="text-align:center">결제하기</h1></a>
</body>
</html>
