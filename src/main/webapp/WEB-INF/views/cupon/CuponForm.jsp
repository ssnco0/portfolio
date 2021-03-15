<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post"   action="${contextPath}/coupon/addCoupon.do">
	<h1  class="text_center">쿠폰 페이지</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">결제번호</td>
	      <td width="400"><input type="text" name="payNum"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">결제금액</td>
	      <td width="400"><input type="text" name="payAco"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">실 결제금액</td>
	       <td width="400"><p><input type="text" name="payReal"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">사용 마일리지</td>
	       <td width="400"><p><input type="text" name="payUseMil"></td>
	    </tr>
	      <tr>
	       <td width="200"><p align="right">처리유형</td>
	       <td width="400"><p><input type="text" name="payType"></td>
	    </tr>
	      <tr>
	       <td width="200"><p align="right">가맹점아이디</td>
	       <td width="400"><p><input type="text" name="stoId"></td>
	    </tr>
	      <tr>
	       <td width="200"><p align="right">사용자아이디</td>
	       <td width="400"><p><input type="text" name="cusId"></td>
	    </tr>
	      <tr>
	       <td width="200"><p align="right">쿠폰아이디</td>
	       <td width="400"><p><input type="text" name="couId"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="결제하기">         <input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
