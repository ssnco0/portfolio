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
 <style>
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
  </style>
  <meta charset="UTF-8">
  <title>글목록창</title>
</head>
<script>
	function fn_articleForm(isLogOn,articleForm,loginForm){
	  if(isLogOn != '' && isLogOn != 'false'){
	    location.href=articleForm;
	  }else{
	    alert("관리자 로그인 후 글쓰기가 가능합니다.")
	    location.href=loginForm+'?action=/ntc/articleForm.do';
	  }
	}
</script>
<body>
<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">공지사항 <span class="path">

				</div>
			</div>
			<!-- location_area -->

		<div class="bodytext_area box_inner body_area">
		<div id="inner1">
	<c:if test="${managerInfo.manId != null }">		
		<p class="btn_line txt_right"><a href="javascript:fn_articleForm('${isLogOn}','${contextPath}/ntc/articleForm.do', 
                                                    '${contextPath}/main.do')"class="btn_bbs">글쓰기</a></p>
	</c:if>
	<table class="bbsListTbl mesg" id="bbs">
			<thead>
  <tr height="7" align="center"  bgcolor="lightgreen">
     <th >No</th>
     <th >작성자</th>              
     <th >제목</th>
     <th >작성일</th>
  </tr>
  </thead>
  <tbody>
<c:choose>
  <c:when test="${articlesList ==null }" >
    <tr  height="8">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${articlesList !=null }" >
    <c:forEach  var="article" items="${articlesList }" varStatus="articleNum" >
     <tr align="center" >
	<td >${articleNum.count}</td>
	<td >${article.ntcitWriter }</td>
	<td align='left' >
	<span style="padding-right:30px"></span>
	        <a class='cls1' href="${contextPath}/ntc/viewArticle.do?articleNO=${article.ntcNo}">${article.ntcTitle }</a>
	       
	  </td>
	  <td  >${article.ntcDate}</td> 
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
    </tbody>
</table>
<!-- <a  class="cls1"  href="#"><p class="cls2">글쓰기</p></a> -->
<br>
<%-- <a  class="cls1"  href="javascript:fn_articleForm('${isLogOn}','${contextPath}/ntc/articleForm.do', 
                                                    '${contextPath}/member/loginForm.do')"><p class="cls2">글쓰기</p></a> --%>

</div>
</div>
</body>
</html>