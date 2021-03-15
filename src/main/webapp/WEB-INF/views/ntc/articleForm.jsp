<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="memberinfo" value="${cusId}" />
<%
    request.setCharacterEncoding("UTF-8");
%>

<head>
<meta charset="UTF-8">
<title>글쓰기창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	var cnt = 1;
	function fn_addFile() {
		$("#d_file")
				.append("<br>" + "<input type='file' name='file"+cnt+"' />");
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
					<p class="location">공지사항 <span class="path"></p>

				</div>
			</div>
			<!-- location_area -->
	<div class="bodytext_area box_inner body_area">
	<div id="inner2">
	<form name="articleForm" method="post"  id="frm" action="${contextPath}/ntc/addNewArticle.do"   enctype="multipart/form-data">
		<ul class="bbsview_list">
		
					<li class="bbs_title" >제목 :<input class="atc_tit_form" type="text" name="ntcTitle" ></li>
					<li class="bbs_content">
						<div class="editer_content">
							<textarea name="ntcContents" id="i_content_form" rows="5" cols="33"></textarea>
						</div>
					</li>
				</ul>
				
		<!-- 	<input type="submit"	value="글쓰기" />  -->
	<p class="btn_line txt_right">	
		<a href="#" onclick="document.getElementById('frm').submit();" class="btn_bbs">글쓰기</a>
		<a href="${contextPath}/ntc/listArticles.do" class="btn_bbs">목록</a>
	</p>

					</form>
		</div>
	</div>
</body>
</html>
