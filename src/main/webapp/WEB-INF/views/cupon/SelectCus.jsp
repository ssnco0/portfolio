<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
.text_center {
	text-align: center;
}
</style>
</head>
<body>
	<form method="post" action="${contextPath}/coupon/addCoupon.do">
		<h1 class="text_center">쿠폰 등록</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">할인금액</td>
				<td width="400"><input type="text" name="cupDiscount"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">내용</td>
				<td width="400"><textarea name="cupAdvContents"></textarea>
			</tr>
			

			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="등록">
				 <input	type="reset" value="다시입력"></td>
			</tr>
		</table>
		<input type="hidden" name="cupKind" value="0">
		<input type="hidden" name="stoId" value="${storeInfo.stoId}")>
		<input type="hidden" name="">
		<input type="hidden" name="">
		<input type="hidden" name="">
	</form>
</body>