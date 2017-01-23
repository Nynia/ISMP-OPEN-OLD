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
  <SCRIPT src="js/Clock.js" type=text/javascript></SCRIPT>
  <script>
	
	function cpdetail(id,name){
		window.self.location.href="cpdetail.jsp?id="+id+"&name="+name;
	}
	
	function cppro(id,name){
		window.self.location.href="cppro.jsp?id="+id+"&name="+name;
	}
	
	function query(){
		window.self.location.href="queryoutput?type=1&cpid="+$("#cpsel").val();
	}
</script>
</head>
<body>

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">按CP厂家查询</strong> / <small>outPut List</small></div>
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
      <select id="cpsel" name="cpsel">
      <%List cplist=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id!=1");
      Iterator it = cplist.iterator();  
							while(it.hasNext()){  
							Map	m=(Map)it.next();
       %>
      	<option value="<%=m.get("cp_id")%>"><%=m.get("cp_name") %></option>
      	<%} %>
      </select>
      <button onclick="query()" class="am-btn am-btn-default" type="button">查询</button>
        
      </div>

    </div>
    <!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
  </body>
</html>
<!--  -->