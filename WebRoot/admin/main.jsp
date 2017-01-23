<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
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
  <SCRIPT src="js/Clock.js" type=text/javascript></SCRIPT>
  <script>
  	function iFrameHeight() {

        var ifm= document.getElementById("selectmain");

        var subWeb = document.frames ? document.frames["selectmain"].document :

ifm.contentDocument;

            if(ifm != null && subWeb != null) {

            ifm.height = subWeb.body.scrollHeight;
            }
    }
  </script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，XINWO UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>江苏公信</strong> <small>业务汇聚平台</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;">嗨：）<%=request.getSession().getAttribute("username") %>，<span id="clock" class=""></span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 网站首页 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <!-- <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>-->
          <li><a href="login.jsp"><span class="am-icon-power-off"></span> 注销</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  
  <div class="admin-sidebar">
  <%
	int role=Integer.parseInt(request.getSession().getAttribute("role").toString());
	if(role==1){
		//管理员
		%>
		<jsp:include page="left.jsp"></jsp:include>
		<%
	}else{
		//操作员
		%>
		<jsp:include page="leftcp.jsp"></jsp:include>
		<%
	}
%>
  
  </div>
  
  <div class="admin-content">
    <%if(role==1){%>
     <iframe id="selectmain" name="selectmain" onload="iFrameHeight()" src="mainindex.jsp?role=<%=role %>" width=100% frameborder="0" scrolling="no"></iframe>
    <%}else{%>
     <iframe id="selectmain" name="selectmain" onload="iFrameHeight()" src="mainindex2.jsp?role=<%=role %>" width=100% frameborder="0" scrolling="no"></iframe>
    <%} %>
 
  </div>
  
</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2015 江苏省公用信息有限公司 | 宽带运营中心, Inc.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
<SCRIPT type=text/javascript>
			var clock = new Clock();
			clock.display(document.getElementById("clock"));
		</SCRIPT>
</body>
</html>

