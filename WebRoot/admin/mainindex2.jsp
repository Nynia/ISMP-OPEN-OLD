<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%String role=request.getParameter("role"); %>
<!doctype html>
<html class="no-js">
<head>
<%
ApplicationContext ctx = WebApplicationContextUtils
.getWebApplicationContext(this.getServletContext());
JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");%>
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
  <SCRIPT src="js/Clock.js" type=text/javascript></SCRIPT>
  
</head>
<body>
<!-- content start -->
  

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>欢迎进入公信公司业务汇聚平台</small></div>
    </div>

    <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
    
      <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/><%
      List cp=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id=?",new Object[]{request.getSession().getAttribute("cpid").toString()});
      Map cpm=(Map)cp.get(0);
      out.print(cpm.get("cp_name"));
       %><br/></a></li>
      <li><a href="cpprolist.jsp?id=<%=request.getSession().getAttribute("cpid").toString() %>" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>接入产品<br/>
      <%List pro=(List)jdbcTemplate.queryForList("select * from product_info where cp_id=?",new Object[]{request.getSession().getAttribute("cpid").toString()});
      out.print(pro.size()+"个"); %>
      </a></li>
      
      <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>技术支持<br/>
      <a target='_blank' href='tencent://message/?uin=30468749'><img border='0' src='http://wpa.qq.com/pa?p=2:30468749:51' alt='点击咨询' title='点击咨询'/></a>
      </a></li>
    </ul>

    
    
  <!-- content end -->
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
  </body>
  </html>
  