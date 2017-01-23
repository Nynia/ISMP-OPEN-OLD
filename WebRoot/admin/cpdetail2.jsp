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
String name=request.getParameter("name");
String id=request.getParameter("id");
List cpList=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id=?",new Object[]{id});
Map cpMap=(Map)cpList.get(0);

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
	if($.trim($("#cpname").val())==""||$.trim($("#companyname").val())==""||$.trim($("#companyaddr").val())==""||$.trim($("#updateurl").val())==""){
		alert("请将必填项填完再进行提交！");
		return;
	}
		$.ajax(
				{
					type : "post",
					url : "updatecpinfo",
					data : $('#myform').serialize(),// 要提交的表单 
					dataType : "text",
					error : function()
					{
						//alert("表单提交失败");
					},
					success : function(data)
					{
					//alert(data);
						if (data == 'updateOK')
						{
							alert("更新cp信息成功");
							//window.self.location.href="cplist";
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
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"><%=name %></strong> / <small>CP INFO</small></div>
  </div>

  <div class="am-tabs am-margin" data-am-tabs>
    <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade" id="tab2">
      
      
        <form class="am-form" style="text-align:left;" method="post" id="myform"  name="myform">
						<input type="hidden" id="id" name="id" value="<%=id%>"/>
       
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP名称
            </div>
            <div class="am-u-sm-4">
              <input maxlength="30" value="<%=cpMap.get("cp_name") %>" type="text" id="cpname" name="cpname" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP公司名称
            </div>
            <div class="am-u-sm-4">
              <input maxlength="30" value="<%=cpMap.get("cp_company_name") %>" type="text" id="companyname" name="companyname" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP公司地址
            </div>
            <div class="am-u-sm-4">
              <input maxlength="50" value="<%=cpMap.get("cp_company_addr") %>" type="text" id="companyaddr" name="companyaddr" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填</div>
          </div>
		  
		  <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              CP接入号
            </div>
            <div class="am-u-sm-4">
              <input disabled="disabled" value="<%=cpMap.get("cp_access_num") %>" type="text"  class="am-input-sm">
            </div>
            <div class="am-u-sm-6"></div>
          </div>
		  
		  <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              接收状态更新通知URL
            </div>
            <div class="am-u-sm-4">
              <input maxlength="200" value="<%=cpMap.get("cp_status_update_url") %>" type="text" id="updateurl" name="updateurl" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填</div>
          </div>
		  
		  
        </form>
      </div>

      

    </div>
  </div>

  <div class="am-margin">
    <a type="button" onclick="tj()" class="am-btn am-btn-primary am-btn-xs">提交保存</a>
  </div>
</div>
  
  
    
  </body>
</html>
