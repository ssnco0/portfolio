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
<title>쿠폰등록</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post"   action="${contextPath}/cupon/addCupon.do">
	<h1  class="text_center">쿠폰등록</h1>
	<table  align="center">
		<!-- <tr>
	      <td width="200"><p align="right">쿠폰아이디</td>
	      <td width="400"><input type="text" name="cupId"></td>
	   </tr> -->
	   <tr>
	      <td width="200"><p align="right">할인액</td>
	      <td width="400"><input type="text" name="cupDiscount"></td>
	   </tr>
	   <tr>
	   	  <td colspan="2"><input type="hidden" name="cupKind" value='비승인'></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">광고내용</td>
	      <td width="400"><input type="text" name="cupAdvContents"></td>
	    </tr>
	   
	   <tr>
	      <td width="200"><p align="right">가맹점아이디</td>
	      <td width="400"><input type="text" name="stoId" value="${sotreInfo.stoId}"></td>
	   </tr>
	    
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="등록하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>