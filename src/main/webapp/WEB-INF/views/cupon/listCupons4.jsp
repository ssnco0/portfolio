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

	<div class="bodytext_area box_inner body_area" style=" padding-left: 100px;padding-right: 100px;">
	<form method="post"   action="${contextPath}/cupon/addCupon.do" id="frm">
	<table class="bbsListTbl  pay_1" style=" text-align: center;" >
		
	   <tr>
	      <th width="200"><p>할인액</th>
	      <td width="400"><input type="text" name="cupDiscount">
	      <input type="hidden" name="cupKind" value='비승인'>
	      </td>
	   </tr>
	   
	   <tr>
	      <th width="200"><p>광고내용</th>
	      <td width="400"><input type="text" name="cupAdvContents"></td>
	    </tr>
	   
	   <tr>
	      <th width="200"><p>사용자아이디</th>
	      <td width="400"><input type="text" name="cusId"></td>
	   </tr>
	    
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	  
	    <td><p class="btn_line1 txt_right"/><a href="#" class="btn_bbs"  onclick="document.getElementById('frm').submit();" >등록</a>
	    		<a href="#" class="btn_bbs"  onclick="document.getElementById('frm').reset();" >재입력</a></p></td>
	    </tr>
	</table>
	</form>
	
<div class="userList">
	<table class="bbsListTbl  pay_2" style=" text-align: center;" >
	<thead>
     <tr align="center">
      	<th><b>No</b></th>
      	<th><b>사용자</b></th>
  	 </tr>
  	</thead>
  
 <c:forEach var="cupon" items="${cuponsList4}" varStatus="cupNo">     
   <tr align="center">
      <td>${cupNo.count}</td>
      <td>${cupon.cusId}</td>
   </tr>
  </c:forEach>   
</table>
</div>
</div>

</body>
</html>
