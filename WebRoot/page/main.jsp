<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="page/js/jquery-1.9.1.min.js"></script>
  </head>
  
  <body>
  	<div>
	  	<c:choose>
	  		<c:when test="${cp_id==1}">
	  			<jsp:include page="/page/query_manager.jsp"/>
	  		</c:when>
	  		<c:otherwise>
	  			<jsp:include page="/page/query_sp.jsp?${cp_id}"/>
	  		</c:otherwise>
	  	</c:choose>
  	</div>
  </body>
</html>
