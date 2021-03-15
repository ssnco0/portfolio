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


</head>

<body>
	<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">쪽지함 <span class="path">></span> 상세보기	</p>

				</div>
			</div>
			<!-- location_area -->
		
<!-- body_area -->
            <div class="body_area">
                <div id="body_content">
                    <div id="t_t">
                      <h1>내 쪽지함</h1>
                    </div>
                    
                    <div id="inner">
                        <ul class="bbsview_list detail">
                            <li class="bbs_title">시스템 업뎃하니까 좀 기다려</li>
                            <li class="bbs_hit">작성자 : <span>관리자</span></li>
                            <li class="bbs_date">발신일 : <span>2018.08.09</span></li>
                            <li class="bbs_content">
                                <div class="editer_content">
                                    업뎃함
                                </div>
                            </li>
                        </ul>
                        <p class="btn_line txt_right"><a href="#" class="btn_bbs">목록</a></p>
                        <ul class="near_list mt20">
                            <li><h4 class="prev">다음글</h4><a href="javascript:;">또 점검이다</a></li>
                            <li><h4 class="next">이전글</h4><a href="javascript:;">점검이다</a></li>
                        </ul>
                        <a href="${contextPath}/message/removeMessage.do?id=${message.umNum }">쪽지 삭제</a>
<a  href="${contextPath}/message/messageRegiForm.do"><h1 style="text-align:center">쪽지 전송</h1></a>
                    </div>
                </div>
			 </div>
			 <!-- //body_area -->
			 


</body>
</html>
