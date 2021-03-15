<!-- 2021-03-08 -->

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
<title>쿠폰목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>


<script>
$(document).ready(function(){
   
    $("#checkall").click(function(){
        
        if($("#checkall").prop("checked")){
            
            $("input[name=chk]").prop("checked",true);
            
        }else{
            
            $("input[name=chk]").prop("checked",false);
        }
    })
})
</script>
</head>
<body>
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				Local <span class="in">Mileage</span> Management
			</h2>
			<p class="location">
				마일리지 조회 <span class="path">></span> 사용 마일리지
			</p>

		</div>
	</div>
	<!-- location_area -->

	<!-- <div class="bodytext_area box_inner body_area"> -->

<div class="bodytext_area box_inner body_area" style=" padding-left: 100px;padding-right: 100px;">
<p class="btn_line1 txt_right" >
		<a href="${contextPath}/cupon/listCupons4.do" class="btn_bbs">쿠폰등록</a></p>

	<!-- <table class="bbsListTbl mesg"> -->
	<table class="bbsListTbl  pay_2" style=" text-align: center;" >
	  <thead>
    	<tr align="center"   bgcolor="lightgreen">
      		<th><b>No</b></th>
      		<th><b>할인액</b></th>
      		<th><b>쿠폰상태</b></th>
      		<th><b>광고내용</b></th>
     		    
      		
   		</tr>
     </thead>
   <tbody>
   <c:choose>
  	<c:when test="${cuponsList ==null }" >
    	<tr  height="8">
      	  <td colspan="4">
         	<p align="center">
            	<b><span style="font-size:9pt;">등록된 쿠폰이 없습니다.</span></b>
       	 	</p>
      	  </td>  
    	</tr>
    </c:when>
   <c:when test="${cuponsList != null }" >
 <c:forEach var="cupon" items="${cuponsList}" varStatus="cupNo">     
   <tr align="center">
      <td ><name=chk id=check>${cupNo.count}</td>
      <td>${cupon.cupDiscount}</td>
      <td>${cupon.cupKind}</td>
      <td>${cupon.cupAdvContents}</td>
     
      
      
    </tr>
  </c:forEach>   
       </c:when>
    </c:choose>
  </tbody>
</table>
</div>

</body>
</html>
