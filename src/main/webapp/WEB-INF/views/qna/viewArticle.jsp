<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="memberinfo" value="${cusId}" />
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
	    obj.action="${contextPath}/qna/listArticles.do";
	    obj.submit();
     }
     
     function backToReply(obj){
 	    obj.action="${contextPath}/qna/viewArticle.do?articleNO="+${article.qnaNo};
 	    obj.submit();
      }
     
	 function fn_enable(obj){
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/qna/modArticle.do";
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
				QnA <span class="path">
			</p>

		</div>
	</div>
	<!-- location_area -->

	<!-- bodytext_area -->
	<div class="bodytext_area box_inner">
		<div id="inner2">
			<form name="frmArticle" method="post" action="${contextPath}"enctype="multipart/form-data">

				<!-- 글 정보 -->
				<ul class="bbsview_list">
					<%-- 		<li class="bbs_date">글번호 : ${article.qnaNo }</li> --%>
					<li class="bbs_title"><input class="atc_tit" type=text
						value="${article.qnaTitle }" name="title" id="i_title" disabled /></li>
					<li class="bbs_hit">작성일 : ${article.qnaCreateDate}</li>
					<li class="bbs_date">작성자 : ${article.qnaWriter}</li>
					<li class="bbs_content">
					
						<div class="editer_content">
						<textarea name="content" id="i_content" class="i_content_form" disabled>${article.qnaContents }</textarea>
						
						</div>
					</li>
				</ul>
				<input type="hidden" name="articleNO" value="${article.qnaNo}" />

				<!-- /글 정보 -->
				<!-- 댓글  -->
				
		<c:forEach var="reply" items="${reply }">
				<ul id="rep" >
					<div id="rep_inner">
						<div id="rep_inner_1">
							<a id="rep_img" href="#"></a>
						</div>
						<div id="rep_con">
							<li class="rep_1" id="rep_1">${reply.reWriter}</li>
							<li class="rep_1" id="rep_2">${reply.reContents}</li>
							<li class="rep_1" id="rep_3">${reply.reDate}</li>
						</div>
					</div>
				</ul>
			</c:forEach>

				<!-- /댓글 -->
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
					<c:if test="${id.cusId == article.qnaWriter }">
							
					<p class="btn_line txt_right">
						<a href="#" class="btn_bbs" onClick="fn_enable(frmArticle)">수정</a>
						<a href="#" class="btn_bbs" onClick="fn_remove_article('${contextPath}/qna/removeArticle.do', ${article.qnaNo})">삭제</a>
						<a href="${contextPath}/qna/listArticles.do" class="btn_bbs">목록</a>
					</p>	 
						</c:if>
						<c:if test="${id.cusId != article.qnaWriter }">
							<p class="btn_line txt_right">
						<a href="${contextPath}/qna/listArticles.do" class="btn_bbs">목록</a>
					</p>
						</c:if>
						</li>
				</ul>

			</form>


	

			<!-- /수정/삭제 -->
			<!-- 댓글 작성 -->
			<c:if test="${managerInfo.manId != null}">
			<form method="post" id="reqly" action="${contextPath}/reply/write"
				enctype="multipart/form-data">
				<ul id="reply">

					<ul>

						<li><input type="text" name="reContents" id="rp_con">
							<button type="submit">댓글 작성</button></li>
					</ul>

				
				</ul>
				<input type="hidden" name="reWriter" value="${managerInfo.manId}"
					disabled /> <input type="hidden" name="qnaNo"
					value="${article.qnaNo}">
			</form>
			</c:if>
		</div>
	</div>

</body>
</html>