<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <script src="${contextPath}/resources/jquery/jquery-3.5.1.min.js"type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/swiper.min.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/pw.css">
	<link rel="stylesheet" type="text/css"href="${contextPath}/resources/css/sub.css">
<%-- <link rel="stylesheet" type="text/css"href="${contextPath}/resources/css/loginEx.css"> --%>
	<script src="${contextPath}/resources/jquery/memberForm.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/rollmain.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.easing.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/common.js" type="text/javascript"></script>
	<script src="${contextPath}/resources/jquery/jquery.smooth-scroll.min.js" type="text/javascript"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
 	<script src="${contextPath}/resources/jquery/login.js" type="text/javascript"></script>
 	
 	<style>
 	  #container {
        width: 100%;
/*         height:27%; */
		bottom:0;
        margin: 0px auto;
      }
      #header {
        padding: 0px;
        margin-bottom: 0px;
        border: 0px solid #bcbcbc;
      }   
       #content {
        width: 100%;
        padding: 0px;
        margin-right: 0px;
        float: left;
        border: 0px solid #bcbcbc;
      }
      #footer {
        clear: both;
        padding: 5px;
        border: 0px solid #bcbcbc;
        background-color: rgb(52 58 64);
        height:100%;
      }
 	</style>
 	
    <title><tiles:insertAttribute name="title" /></title>
  </head>
    <body>
   
        <div id="container">
      <div id="header">
         <tiles:insertAttribute name="header"/>
      </div>
      <div id="content">
          <tiles:insertAttribute name="body"/>
      </div>
      <div id="footer">
          <tiles:insertAttribute name="footer"/>
      </div>
    </div>
 
  </body>
</html>