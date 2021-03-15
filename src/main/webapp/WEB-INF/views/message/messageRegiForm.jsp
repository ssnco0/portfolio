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
<title>쪽지등록</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">쪽지 보내기 <span class="path">

				</div>
			</div>
			<!-- location_area -->
		
<div class="bodytext_area box_inner">
	<form method="post"   action="${contextPath}/message/transMessage.do">
	<h1  class="text_center">쪽지 보내기</h1>
	<table  align="center">
		<tr>
	      <td width="200"><p align="right">제목</td>
	      <td width="400"><input type="text" name="umTitle"></td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">내용</td>
	      <td width="400"><input type="text" name="umContents"></td>
	    </tr>	    
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="전송"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
	</div>
</body>