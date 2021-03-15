<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- 
<c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  />

 --%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>글보기</title>
<style>
#tr_file_upload {
	display: none;
}

#tr_btn_modify {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
     function backToList(obj){
	    obj.action="${contextPath}/intro/listArticles.do";
	    obj.submit();
     }
 	function backToReply(obj){
	 	obj.action="${contextPath}/intro/viewArticle.do?articleNO="+${article.siNo};
	 	obj.submit();
	}
     
 
	 function fn_enable(obj){
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("i_imageFileName").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_file_upload").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/intro/modArticle.do";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
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
				가맹점 소개 <span class="path">
			</p>

		</div>
	</div>
	<!-- location_area -->

	<!-- bodytext_area -->
	<div class="bodytext_area box_inner">
		<div id="inner2">
			<form name="frmArticle" method="post" action="${contextPath}"
				enctype="multipart/form-data">

				<!-- 글 정보 -->
				<ul class="bbsview_list">
					
					<li class="bbs_title"><input class="atc_tit" type=text
						value="${article.siTitle }" name="title" id="i_title" disabled /></li>
					<li class="bbs_hit">작성일 : ${article.siCreateDate}</li>
					<li class="bbs_date">작성자 : ${article.stoId}</li>
					<li class="bbs_content">
					<c:choose>
					<c:when	test="${not empty article.sBImageFileName && article.sBImageFileName!='null'}">
						<div id="img_div">
						<ul>
							<li class="bbs_hit"><input type="file" name="sBImageFileName"id="i_imageFileName" disabled onchange="readURL(this);" /></li>
						</ul>
						<ul>
							
							
							<input type="hidden" name="originalFileName"value="${article.sBImageFileName}" />
							 <img src="${contextPath}/download.do?articleNO=${article.siNo}&sBImageFileName=${article.sBImageFileName}"
								id="preview" class="preview"/><br>
							
														
						</ul>
						
						</div>
					</c:when>
					<c:otherwise>
						<ul id="tr_file_upload">
							
							<li><input type="hidden" name="originalFileName"value="${article.sBImageFileName}" /></li>
				
							<li>
								<img id="preview" /><br> 
								<input type="file"	name="sBImageFileName " id="i_imageFileName" onchange="readURL(this);" />
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
						<div class="editer_content">
						<textarea name="content"  id="i_content" class="i_content_form" disabled>${article.siContents }</textarea>

								
						</div>
					</li>
				</ul>
				<input type="hidden" name="articleNO" value="${article.siNo}" />
				
				<!-- /글 정보 -->
				
	<!-- 수정/삭제 -->
				<ul id="tr_btn_modify">
					<li>	
						<p class="btn_line txt_right">
							<a href="#" class="btn_bbs" onClick="fn_modify_article(frmArticle)">확인</a>
							<a href="#" class="btn_bbs" onClick="backToReply(frmArticle)">취소</a>
						</p>	 
					</li>
				</ul>
				<ul id="tr_btn">
					<li>  
					<c:if test="${id.stoId == article.stoId }">
					<p class="btn_line txt_right">
						<a href="#" class="btn_bbs" onClick="fn_enable(frmArticle)">수정</a>
						<a href="#" class="btn_bbs" onClick="fn_remove_article('${contextPath}/intro/removeArticle.do', ${article.siNo})">삭제</a>
						
					   <a href="${contextPath}/intro/listArticles.do" class="btn_bbs">목록</a>
					</p>	 
						</c:if>
						<c:if test="${id.stoId != article.stoId }">
				<p class="btn_line txt_right">
						<a href="${contextPath}/intro/listArticles.do" class="btn_bbs">목록</a>
					</p>
					</c:if>
						</li>						
				</ul>
				
			</form>

			


		</div>
	</div>

</body>
</html>