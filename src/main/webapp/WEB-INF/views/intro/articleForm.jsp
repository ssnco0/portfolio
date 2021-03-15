<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<c:set var="storeinfo"  value="${stoId}"  /> 
<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
	      var reader = new FileReader();
	      reader.onload = function (e) {
	        $('#preview').attr('src', e.target.result);
        }
       reader.readAsDataURL(input.files[0]);
    }
}  
function backToList(obj){
  obj.action="${contextPath}/intro/listArticles.do";
  obj.submit();
}

var cnt=1;
function fn_addFile(){
	  $("#d_file").append("<br>"+"<input type='file' name='file"+cnt+"' />");
	  cnt++;
}  
</script>
 <title>글쓰기창</title>
</head>
<body>
<!-- location_area -->
			<div class="location_area member">
				<div class="box_inner">
					<h2 class="tit_page">Local <span class="in">Mileage</span> Management</h2>
					<p class="location">가맹점 소개 작성 <span class="path">	</p>

				</div>
			</div>
			<!-- location_area -->
<div class="bodytext_area box_inner body_area">

 	<div class="bodytext_area box_inner">
		<div id="inner2">
 <form name="articleForm" method="post" id="frm"  action="${contextPath}/intro/addNewArticle.do"   enctype="multipart/form-data">

				<!-- 글 정보 -->
				<ul class="bbsview_list">
					<li class="bbs_title" >제목 :<input class="atc_tit_form" type="text" name="siTitle" ></li>
					<li class="bbs_hit"><input type="file" name="sBImageFileName"  onchange="readURL(this);" /></li>
					<li class="bbs_hit"><input type="hidden" /></li>
					<li class="bbs_content">
						<div class="editer_content">
							<textarea name="siContents" id="i_content_form" rows="5" cols="33">
							
							</textarea>
						</div>
						<img  id="preview" src="#"   width=200 height=200/>
					</li>
				
				
				
					
					
				</ul>
				<p class="btn_line txt_right">	
		<a href="#" onclick="document.getElementById('frm').submit();" class="btn_bbs">글쓰기</a>
		<a href="${contextPath}/intro/listArticles.do" class="btn_bbs">목록</a>
	</p>
			
</form>

				</div>
		</div>
  </div>
</body>
</html>
