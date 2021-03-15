<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"href="${contextPath}/resources/css/scp.css">
</head>
<script>
	function setText() {
		var minus = document.getElementById("usealbeMil").value - document.getElementById("useMileage").value;
		if(document.getElementById("useMileage").value < 0 ){
			alert("사용 마일리지는 양수만 가능합니다!!");
		}
		else{
			if (minus < 0 ) {
				alert("보유 마일지가 부족합니다!!");
			} else {
				opener.document.getElementById("SelectCusIdParent").value = document
					.getElementById("SelectCusIdChild").value;
			
				opener.document.getElementById("useMileage").value = document
					.getElementById("useMileage").value;

				opener.document.getElementById("cupNum").value = document
					.getElementById("useCupon").value;
			
				opener.document.getElementById("cupDiscount").value = document
					.getElementById("useCuponDiscount").value;
			
				opener.document.getElementById("cupId").value = document
					.getElementById("useCuponId").value;
			
				window.close();
			}
		}
	}

	function sc(a,b,c) {
		document.getElementById("useCuponId").value = a
		document.getElementById("useCupon").value = b
		document.getElementById("useCuponDiscount").value = c
	}
</script>
<body>
	<form method="post" action="${contextPath}/payment/selectCusid.do">
		<table class="bbsListTbl" style="margin-left: auto; margin-right: auto; text-align: center;">
			<tr>
				<th class="head">사용자 아이디</th>
				<td><input type="text" name="SelectCusIdChild"
					id="SelectCusIdChild" value="${member.cusId }" /></td>
				<td><input type="submit" id="search" name="cusId" value="조회" /></td>
				<td><input type="button" id="submit" value="사용" onclick="setText()" /></td>
			</tr>
			<tr>
				<th class="head">사용가능 마일리지</th>
				<td><input type="text" id="usealbeMil" readonly
					value="${member.cusTotMil }" /></td>
			</tr>
			<tr>
				<th class="head">마일리지 사용</th>
				<td><input type="number" id="useMileage" value="0" min="0" /></td>
			</tr>
			<tr>
				<th class="head">쿠폰아이디</th>
				<td><input type="number" id="useCuponId" value="0" readonly
					min="0" /></td>
			</tr>
			<tr>
				<th class="head">쿠폰번호</th>
				<td><input type="number" id="useCupon" value="0" readonly /></td>
			</tr>
			<tr>
				<th class="head">쿠폰 할인액</th>
				<td><input type="number" id="useCuponDiscount" value="0"
					min="0" readonly /></td>
			</tr>
			<tr>
			</tr>
		</table>
		<table class="bbsListTbl" style="width: 80%; margin-left: auto; margin-right: auto; text-align: center;">
			<tr>
				<th>쿠폰아이디</th>
				<th>쿠폰번호</th>
				<th>할인액</th>
				<th>사용가능매점</th>
			</tr>
			<c:forEach var="cuponList" items="${cuponList}">
				<c:if test="${cuponList.stoId == stoId}">
					<tr>
						<td><input type="text" id="SelectCupon"value="${cuponList.cupId}"></td>
						<td><input type="text" id="SelectCupon"value="${cuponList.cupQrNo}"></td>
						<td><input type="text" id="SelectCuponDiscount"value="${cuponList.cupDiscount}"></td>
						<td><input type="text" id="SelectCuponDiscount"value="${cuponList.stoId}"></td>
						<td><input type="button" value="선택"
						onclick="sc(${cuponList.cupId},${cuponList.cupQrNo},${cuponList.cupDiscount})" /></td>
					</tr>
				</c:if>
			</c:forEach>

		</table>
	</form>
</body>
</html>