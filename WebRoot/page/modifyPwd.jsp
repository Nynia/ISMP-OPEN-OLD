<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="page/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function checkModifyPwd(){
			if($("#account").val()==""||$("#newPwd1").val()==""||$("#newPwd2").val()==""){
				return false;
			}
			if($("#newPwd1").val()!=$("#newPwd2").val()){
				return false;
			}
			$("form").submit();
			
		}
	</script>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/modifyPwdServlet" method="post">
  		账&nbsp;&nbsp;号：<input id="account" name="account" /><br/>
  		新密码：<input id="newPwd1" name="newPwd1" /><br/>
  		确认新密码：<input id="newPwd2" name="newPwd2" /><br/>
  		<input type="button" value="确定修改" onclick="return checkModifyPwd()"/>
  	</form>
  </body>
</html>
