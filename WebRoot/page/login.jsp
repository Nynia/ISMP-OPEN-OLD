<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
		function checkLogin(){
			var name=$("#name").val();
			var pwd=$("#pwd").val();
			if($("#name").val().length==0){
				$("#nameCheckDiv").html("请输入用户名");
				$("#nameCheckDiv").css("color","red");
				return false;
			}else{
				$("#nameCheckDiv").html("ok");
				$("#nameCheckDiv").css("color","green");
			}
			if($("#pwd").val().length==0){
				$("#pwdCheckDiv").html("请输入密码");
				$("#pwdCheckDiv").css("color","red");
				return false;
			}else{
				$("#pwdCheckDiv").html("ok");
				$("#pwdCheckDiv").css("color","green");
			}
			$.ajax({
				type:"post",
				url:"loginServlet",
				data:"name="+name+"&&pwd="+pwd,
				dataType:"text",
				success:function(data){
					if(data=="success"){
						location.href="page/main.jsp";
					}else{
						$("#checkLoginDiv").html("账号或密码不正确");
						$("#checkLoginDiv").css("color","red");
					}
				}
			});
		}

		function modifyPwd(){
			location.href="page/modifyPwd.jsp";
		}
	</script>
  </head>
  
  <body>
  	<form>
  		<div>
  			<div style="display: inline">
  				登陆名：<input id="name" name="name"/>
  			</div>
  			<div id="nameCheckDiv" style="display: inline"></div>
  		</div>
  		<div>
  			<div style="display: inline">
  				密&nbsp;&nbsp;码：<input id="pwd" name="pwd"/>
  			</div>
  			<div id="pwdCheckDiv" style="display: inline"></div>
  		</div>
  		<div>
  			<div style="display: inline">
  				<input type="button" value="登陆" onclick="checkLogin()"/>
  			</div>
  			<div id="checkLoginDiv" style="display: inline"></div>
  		</div>
  	</form>
  	<div>
  		<input type="button" value="修改密码" onclick="modifyPwd()"/>
  	</div>
  </body>
</html>
