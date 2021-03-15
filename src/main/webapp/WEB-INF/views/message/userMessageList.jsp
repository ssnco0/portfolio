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
<title>쪽지목록</title>
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
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">마이페이지 <span class="path">></span> 쪽지함	</p>

				</div>
			</div>
			<!-- location_area -->
		
<div class="bodytext_area box_inner body_area">
<div id="inner1">
<p class="btn_line txt_right"><ahref="${contextPath}/message/removeMessage.do?id=${message.umNum }" class="btn_bbs">삭제</a></p>

	<table class="bbsListTbl mesg">
		<thead>
    <tr align="center"   bgcolor="lightgreen">
      <th ><input type=checkbox id=checkall name=checked><b>No</b></th>
      <th><b>제목</b></th>
      <th><b>내용</b></th>
      <th><b>수신일</b></th>
   </tr>
   </thead>
   <tbody>
 <c:choose>
  <c:when test="${messageList == null }" >
    <tr  height="8">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${messageList !=null }" >
 <c:forEach var="message" items="${messageList}" varStatus="meNum">     
   <tr align="center">
      <td ><input type=checkbox name=chk id=check>${meNum.count}</td>
      <td >${message.umTitle}</td>
      <td ><a href="${contextPath}/main.do">${message.umContents}</a></td>
      <td >${message.umDate}</td>
    </tr>
  </c:forEach>   
    </c:when>
    </c:choose> 
  </tbody>
</table>
  
 <!--  <p class="btn_line txt_right"><a href="#" class="btn_bbs">전송</a></p> -->
<%-- <a href="${contextPath}/message/removeMessage.do?id=${message.umNum }">쪽지 삭제</a>
<a  href="${contextPath}/message/messageRegiForm.do"><h1 style="text-align:center">쪽지 전송</h1></a> --%>
</div>
</div>
</body>
</html>
