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

<script>
	function SelectCusPhone() {
		var url = "${contextPath}/payment/SelectCusPhone.do";
		var option = "width = 1000, height = 800, top = 500, left = 450";

		openSelectCusPhone = window.open(url, "", option);
	}
	function allDiscount() {
		if (document.getElementById("pay").value < 1) {
			alert("결제 금액을 입력하세요");
		} else {
			var TotDisCount = parseInt(document.getElementById("useMileage").value)
					+ parseInt(document.getElementById("cupDiscount").value);
			var realpay = parseInt(document.getElementById("pay").value)
					- TotDisCount;
			if (realpay < 0 || isNaN(realpay)) {
				alert("결제정보를 다시 입력해 주세요!!");
			} else {
				document.getElementById("realpay").value = realpay;
				document.getElementById("payment").style.display = 'inline';
				document.getElementById("Select").style.display = 'none';
				document.getElementById("pay").readOnly = true;
				document.getElementById("SaveMileage").value = Math
						.floor(document.getElementById("realpay").value / 100);
			}
		}
	}
</script>
<style type="text/css">
#payment {
	display: none;
}
</style>
</head>
<body>
		<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">결제 관리<span class="path">></span> 결제 	</p>

				</div>
			</div>
			<!-- location_area -->
			<div class="bodytext_area box_inner body_area" style=" padding-left: 100px;padding-right: 100px;">	
			<div id="inner1">	
	<form  method="post" action="${contextPath}/payment/PaymentProcess.do" id="frm">
		<table class="bbsListTbl  pay_1" style=" text-align: center;" >
			<tr>
				<th >결제번호</th>
				<td  ><input type="text" name="payNum" value="${payNum+1}"readonly /></td>
				<td></td>
			</tr>
			<tr>
				<th>가맹점 아이디</th>
				<td ><input type="text" name="stoId" value="${stoId}" readonly /></td>
				<td></td>
			</tr>
			<tr>
				<th>결제금액</th>
				<td ><input type="text" id="pay" value="0" min="0" name="payAco" /></td>
				<td></td>
			</tr>
			<tr>
				<th>사용자 아이디</th>
				<td  ><input type="text" id="SelectCusIdParent" name="cusId"	readonly /></td>
				<td><p class="btn_line1 txt_right" onclick="SelectCusPhone()" /><a href="#" class="btn_bbs">조회</a></p></td>
			</tr>
			<tr>
				<th>사용 마일리지</th>
				<td  ><input type="text" id="useMileage" value="0" min="0" name="payUseMil" readonly /></td>
				<td></td>
			</tr>
			<tr>
				<th>쿠폰아이디</th>
				<td  ><input type="text" id="cupId" value="0" readonly	name="cupId" /></td>
				<td></td>
			</tr>
			<tr>
				<th>쿠폰번호</th>
				<td  ><input type="text" id="cupNum" value="0" readonly name="cupQrNo" /></td>
				<td></td>
			</tr>
			<tr>
				<th>쿠폰할인액</th>
				<td  ><input type="text" id="cupDiscount" value="0" readonly min="0"name="cupDisCount" /></td>
				<td></td>
			</tr>
			<tr>
				<th>실 결제금액</th>
				<td  ><input type="text" id="realpay" value="0" readonly min="0"name="payReal" /></td>
				<td> <p id="Select"class="btn_bbs" onclick="allDiscount()">적용</p></td>
<!-- 					<td><p class="btn_line1 txt_right" onclick="SelectCusPhone()" /><a href="#" class="btn_bbs">조회</a></p></td> -->
			</tr>
			<tr>
				<th>적립마일리지</th>
				<td  ><input type="text" id="SaveMileage" name="milStack" value="0" readonly min="0"	name="milStack" /></td>
			<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="다시입력"onclick="window.location.reload()" class="pay_btn"></td>
				<td><input type="submit" value="결제하기" id="payment" class="pay_btn"/></td>
	
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>