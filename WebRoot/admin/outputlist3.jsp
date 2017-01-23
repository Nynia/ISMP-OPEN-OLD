<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate"%>
<!doctype html>
<html class="no-js">
<head>
<%
ApplicationContext ctx = WebApplicationContextUtils
.getWebApplicationContext(this.getServletContext());
JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");


%>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
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
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<script>
	function getme(){
	if($.trim($("#datetimepicker2").val())==""||$.trim($("#datetimepicker3").val())==""){
		alert("请填写日期");
		return;
	}
		window.self.location.href="queryoutput?type=3&start="+$('#datetimepicker2').val()+"&end="+$('#datetimepicker3').val();
	}
</script>
  </head>
  
  <body>
   <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">按日期查询</strong> / <small>Order List</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">

           <!-- <div class="am-form-group am-margin-left am-fl">
              <select id="newstype" onchange="changetype()">
                <option value="0">所有类别</option>
                <option value="1">行业资讯</option>
                <option value="2">装修攻略</option>
              </select>
            </div>-->
            
          </div>
        </div>
      </div>
      
    </div>
    
    <div class="am-g">
      <div class="am-u-sm-12">
      起始日期：<input maxlength="13" type="text" id="datetimepicker2"/>
      结束日期：<input maxlength="13" type="text" id="datetimepicker3"/>
        <a type="button" onclick="getme()" class="am-btn am-btn-primary am-btn-xs">查询</a>
      </div>

    </div>
    
    
  </body>
  <script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>

<script src="js/jquery.datetimepicker.js"></script>
  <script>
  $('#datetimepicker2').datetimepicker({
	lang:'ch',
	timepicker:false,
	format:'Y-m-d',
	formatDate:'Y/m/d',
});
  $('#datetimepicker3').datetimepicker({
	lang:'ch',
	timepicker:false,
	format:'Y-m-d',
	formatDate:'Y/m/d',
});
  </script>
</html>
