<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>江苏公信业务汇聚平台</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="i/favicon.png">
  <link rel="stylesheet" href="css/amazeui.min.css"/>
  <SCRIPT src="js/jquery-1.9.1.min.js" type=text/javascript></SCRIPT>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
  <script>
document.onkeydown=keyListener;    
function keyListener(e){    
	//alert('listening');
	e = e ? e : event;   
		if(e.keyCode == 13){    
   			login();
		}    
}      

function login(){
	var username = $("#username").val();
	var pwd = $("#pwd").val();
	if($.trim(username)=='' || $.trim(pwd)==''){
		alert('请输入用户名或密码');
		window.self.location.reload();
		return;
	}
	
	var login=document.forms[0];
    login.submit();
}

</script>
</head>
<body>
<div class="header"> 
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
      <br>
      <br>
  
    <h3>江苏公信业务汇聚平台登录</h3>
    <hr>
    

    <form action="login" method="post" class="am-form">
      <label for="username">用户名:</label>
      <input type="text" name="username" id="username" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="pwd" id="pwd" value="">
      <br>
      
      <br />
      <div class="am-cf">
        <input type="submit" name="" value="登 录" onclick="login()" class="am-btn am-btn-primary am-btn-sm am-fl">
      </div>
    </form>
    <hr>
    <p>© 2015 版权所有.</p>
  </div>
</div>
</body>
</html>