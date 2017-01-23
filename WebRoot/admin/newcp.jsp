<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate"%>
<!DOCTYPE HTML>
<html>
  <head>
    <%
ApplicationContext ctx = WebApplicationContextUtils
.getWebApplicationContext(this.getServletContext());
JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

%>
    
   <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="css/amazeui.min.css"/>
  <link rel="stylesheet" href="css/admin.css">
    <!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script>


$(function(){
	
});

	function tj(){
	
	if($.trim($("#cpname").val())==""||$.trim($("#cppwd").val())==""||$.trim($("#accessnum").val())==""||$.trim($("#cpaccount").val())==""){
		alert("请将必填项填完再进行提交！");
		return;
	}
	
		$.ajax(
				{
					type : "post",
					url : "createcpaccount",
					data : $('#myform').serialize(),// 要提交的表单 
					dataType : "text",
					error : function()
					{
						//alert("表单提交失败");
					},
					success : function(data)
					{
						if (data == 'OK')
						{
							alert("创建CP帐号成功");
							window.self.location.href="cplist";
						}
					}
				});
	}
	
	function backme(){
		window.self.location.href='cplist';
	}
</script>
  </head>
  
  <body>
  	
  
  <div class="admin-content" style="min-height:1000px;">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">创建CP帐号</strong> / <small>NEW CP</small></div>
  </div>

  <div class="am-tabs am-margin" data-am-tabs>
    <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade" id="tab2">
      
      
        <form class="am-form" style="text-align:left;" method="post" id="myform"  name="myform">
       
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP名称
            </div>
            <div class="am-u-sm-4">
              <input maxlength="10" value="" type="text" id="cpname" name="cpname" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP帐号
            </div>
            <div class="am-u-sm-4">
              <input maxlength="20" value="" type="text" id="cpaccount" name="cpaccount" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP密码
            </div>
            <div class="am-u-sm-4">
              <input maxlength="20" value="" type="text" id="cppwd" name="cppwd" class="am-input-sm">
            </div>
            <div class="am-u-sm-6"></div>
          </div>
		  
		  <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP接入号（前段）
            </div>
            <div class="am-u-sm-4">
              <input maxlength="10" value="" type="text" id="accessnum" name="accessnum"  class="am-input-sm">
            </div>
            <div class="am-u-sm-6"></div>
          </div>
		  
		  
		  
		  
        </form>
      </div>

      

    </div>
  </div>

  <div class="am-margin">
    <a type="button" onclick="tj()" class="am-btn am-btn-primary am-btn-xs">创建帐号</a>
    <button type="button" onclick="backme()" class="am-btn am-btn-primary am-btn-xs">返回列表</button>
  </div>
</div>
  
  
    
  </body>
</html>
