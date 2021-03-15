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
<title>전송할 쿠폰조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>


</head>
<body>
<form method="post"   action="${contextPath}/cupon/addCupon2.do">
	<div class="body_area">		
<table class="bbsListTbl mesg">
			<thead>
    <tr height="5" align="center"   bgcolor="lightgreen">
      <td ><b>쿠폰아이디</b></td>
      <td><b>QR코드번호</b></td>
      <td><b>쿠폰생성일</b></td>
      <td><b>할인액</b></td>
      <td><b>쿠폰사용일자</b></td>
      <td><b>쿠폰상태</b></td>
      <td><b>광고내용</b></td>
      <td><b>사용자아이디</b>
      <td><b>가맹점아이디</b>
      <td><b>전송</b>
    </tr>
   </thead>
   <tbody>
 <c:forEach var="cupon" items="${cuponsList2}" >     
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
      <td><input type="submit" value="전송하기"></td>
    </tr>
  </c:forEach>
  </tbody>
  
</table>
</div>
</form>
</body>
</html>