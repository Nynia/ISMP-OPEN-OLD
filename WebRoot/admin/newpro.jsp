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
List numList=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id=?",new Object[]{request.getSession().getAttribute("cpid")});
Map numMap=(Map)numList.get(0);
String access_num=numMap.get("cp_access_num").toString();

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
	if($("#typesel").val()=="1"){
			$("#dbdiv").show();
			$("#dgdiv").hide();
			$("#tddiv").hide();
			
		}
		if($("#typesel").val()=="2"){
			$("#dbdiv").hide();
			$("#dgdiv").show();
			$("#tddiv").show();
		}
});

	function tj(){
	if($("#typesel").val()=="1"){
	if($.trim($('#proname').val())==""||$.trim($('#accessnum').val())==""||
	$.trim($('#orderstring').val())==""||$.trim($('#price').val())==""||
	$.trim($('#description').val())==""){
		alert("请将必填项完成再进行提交！");
		return;
	}
	}
	if($("#typesel").val()=="2"){
	if($.trim($('#proname').val())==""||$.trim($('#accessnum').val())==""||
	$.trim($('#dgorderstring').val())==""||$.trim($('#price').val())==""||
	$.trim($('#description').val())==""){
		alert("请将必填项完成再进行提交！");
		return;
	}
	}
		$.ajax(
				{
					type : "post",
					url : "newpro",
					data : $('#myform').serialize(),// 要提交的表单 
					dataType : "text",
					error : function()
					{
						//alert("表单提交失败");
					},
					success : function(data)
					{
					//alert(data);
						if (data == 'OK')
						{
							alert("新增产品成功");
							window.self.location.href="prolist?id=<%=request.getSession().getAttribute("cpid")%>";
						}
					}
				});
	}
	
	function backme(){
		window.self.location.href="prolist?id=<%=request.getSession().getAttribute("cpid")%>";
	}
	
	function by(){
		if($("#typesel").val()=="1"){
			$("#dbdiv").show();
			$("#dgdiv").hide();
			$("#tddiv").hide();
			
		}
		if($("#typesel").val()=="2"){
			$("#dbdiv").hide();
			$("#dgdiv").show();
			$("#tddiv").show();
		}
	}
</script>
  </head>
  
  <body>
  	
  
  <div class="admin-content" style="min-height:1000px;">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">新产品接入</strong> / <small>NEW PRODUCT</small></div>
  </div>

  <div class="am-tabs am-margin" data-am-tabs>
    <div class="am-tabs-bd">
      <div class="am-tab-panel am-fade" id="tab2">
      
      
        <form class="am-form" style="text-align:left;" method="post" id="myform"  name="myform">
       
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
             产品名称
            </div>
            <div class="am-u-sm-4">
              <input value="" maxlength="10" type="text" id="proname" name="proname" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
             接入号
            </div>
            <div class="am-u-sm-4">
              <input disabled="disabled" style="float:left;width:100px;" value="<%=access_num %>" type="text"  class="am-input-sm">
              <input style="float:left;width:200px;" maxlength="10" value="" type="text" id="accessnum" name="accessnum" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
             ISMPproductID
            </div>
            <div class="am-u-sm-4">
              <input value="" maxlength="21" type="text" id="ismppid" name="ismppid" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*反填</div>
          </div>
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
             业务代码
            </div>
            <div class="am-u-sm-4">
              <input value="" maxlength="21" type="text" id="bussinessid" name="bussinessid" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*反填</div>
          </div>
          
          
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              订购类型
            </div>
            <div class="am-u-sm-4">
              <select onchange="by()" id="typesel" name="typesel">
              	<option value="1">点播</option>
              	<option value="2">包月</option>
              </select>
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
		  
		  <div class="am-g am-margin-top" id="dbdiv">
            <div class="am-u-sm-2 am-text-right">
            	点播命令字
            </div>
            <div class="am-u-sm-4">
              <input value="" type="text" maxlength="10" id="orderstring" name="orderstring" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
		  
		  <div class="am-g am-margin-top" id="dgdiv">
            <div class="am-u-sm-2 am-text-right">
            	订购命令字
            </div>
            <div class="am-u-sm-4">
              <input maxlength="10" value="" type="text" id="dgorderstring" name="dgorderstring" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
          
		  <div class="am-g am-margin-top" id="tddiv">
            <div class="am-u-sm-2 am-text-right">
            	退订命令字
            </div>
            <div class="am-u-sm-4">
              <input maxlength="10" value="" type="text" id="tdorderstring" name="tdorderstring" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">*必填，不可重复</div>
          </div>
		  
		  <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              产品资费
            </div>
            <div class="am-u-sm-4">
              <input value="" maxlength="5" type="text" id="price" name="price" class="am-input-sm">
            </div>
            <div class="am-u-sm-6"></div>
          </div>
		  
		  <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              产品描述
            </div>
            <div class="am-u-sm-4">
              <input value="" maxlength="100" type="text" id="description" name="description" class="am-input-sm">
            </div>
            <div class="am-u-sm-6"></div>
          </div>
          
          
          
          
        </form>
      </div>

      

    </div>
  </div>

  <div class="am-margin">
    <a type="button" onclick="tj()" class="am-btn am-btn-primary am-btn-xs">提交保存</a>
    <button type="button" onclick="backme()" class="am-btn am-btn-primary am-btn-xs">返回列表</button>
  </div>
</div>
  
  
    
  </body>
</html>
