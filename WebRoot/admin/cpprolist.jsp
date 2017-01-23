<%@page import="util.AmountUtils"%>
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
String id=request.getParameter("id");
List cpname=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id=?",new Object[]{id});
Map nameMap=(Map)cpname.get(0);
String name=nameMap.get("cp_name").toString();
List proList=(List)jdbcTemplate.queryForList("select * from product_info where cp_id=?",new Object[]{id});


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
	
	function prodetail(id,name){
		window.self.location.href="prodetail.jsp?id="+id+"&name="+name;
	}
	
	function cppro(id,name){
		window.self.location.href="cpprolist.jsp?id="+id+"&name="+name;
	}
	
	function verifyme(id){
		if(confirm("确定过审？")){
			$.ajax(
				{
					type : "post",
					url : "verifycp",
					data : "id="+id,// 要提交的表单 
					dataType : "text",
					error : function()
					{
						//alert("表单提交失败");
					},
					success : function(data)
					{
					if(data=="VerifyOK"){
							alert("审核通过");
							window.self.location.href='cplist';
							}
					}
				});
		}
	}
</script>
</head>
<body>

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"><%=name %></strong> / <small>CP Product List</small></div>
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
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
                  <button class="am-btn am-btn-default" type="button">搜索</button>
                </span>
          </div>
        </div>
      </div>
    </div>

    <div class="am-g">
      <div class="am-u-sm-12">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-title">产品名称</th><th class="table-date">订购类型</th><th class="table-date">命令字</th><th class="table-set">价格</th><th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <%
									int i = 0;  
							Iterator it = proList.iterator();  
							while(it.hasNext()){  
								i++;
							Map	m=(Map)it.next();  
							%>
            <tr>
              <td><%=i %></td>
              <td><%=m.get("product_name") %></td>
              <td><%if("1".equals(m.get("orderstring_type").toString())){out.print("点播");}
              if("2".equals(m.get("orderstring_type").toString())){out.print("包月");}
               %></td>
              <td><%=m.get("order_string") %></td>
              <td>￥<%=AmountUtils.changeF2Y(m.get("price").toString()) %>&nbsp;元</td>
              <td><%if("0".equals(m.get("verify_status").toString())){out.print("未审");}else{out.print("已审");} %></td>
              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <a style="background: #fff;" onclick="prodetail(<%=m.get("product_id")%>,'<%=name %>')" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 详情</a>
                    <%
                    int role=Integer.parseInt(request.getSession().getAttribute("role").toString());
				if(role==1){
                   if("0".equals(m.get("verify_status").toString())){  %>
                     
                    <button onclick="verifyme(<%=m.get("cp_id")%>)" class="am-btn am-btn-default am-btn-xs am-text-danger"><span class=""></span> 一键审核</button>
                  <%}
                  }else{%>
                  
                  <%} %>
                  
                  </div>
                </div>
              </td>
            </tr>
            <%} %>
          </tbody>
        </table>
          
          <hr />
      </div>

    </div>
    <!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
  </body>
</html>