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
List cpList=(List)request.getAttribute("list");


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
	
	
	function verifyme(id){
		if(confirm("确定过审？")){
			$.ajax(
				{
					type : "post",
					url : "verifycp",
					data : "type=1&id="+id,// 要提交的表单 
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">CP列表</strong> / <small>CP List</small></div>
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
        <form class="am-form" action="<%=request.getAttribute("servlet")%>" method="post" id="navigatorForm">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-title">厂家</th><th class="table-type">接入产品数</th><th class="table-date">接入日期</th><th class="table-set">状态</th><th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <%
									int i = 0;  
							Iterator it = cpList.iterator();  
							while(it.hasNext()){  
								i++;
							Map	m=(Map)it.next();  
							%>
            <tr>
              <td><%=i %></td>
              <td><a href="#"><%=m.get("cp_name") %></a></td>
              <td><%List proList=(List)jdbcTemplate.queryForList("select * from product_info where cp_id=?",new Object[]{m.get("cp_id")});
											%>
			  <a class="am-btn am-btn-default" style="font-size:12px;" href="prolist?id=<%=m.get("cp_id")%>"><%=proList.size() %></a></td>
              <td><%=m.get("createtime").toString().substring(0,m.get("createtime").toString().length()-2) %></td>
              <td><%if("0".equals(m.get("verify_status").toString())){out.print("未审");}else{out.print("已审");} %></td>
              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
                    <a style="background: #fff;" onclick="cpdetail(<%=m.get("cp_id")%>,'<%=m.get("cp_name") %>')" class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span> 详情</a>
                    <%
                    if("0".equals(m.get("verify_status").toString())){%>
                    <button onclick="verifyme(<%=m.get("cp_id")%>)" class="am-btn am-btn-default am-btn-xs am-text-danger"><span class=""></span> 一键审核</button>
                    <%}%>
                  </div>
                </div>
              </td>
            </tr>
            <%} %>
          </tbody>
        </table>
          <div class="am-cf">
  共 <%=cpList.size() %> 条记录
  <div class="am-fr">
    <ul class="am-pagination">
      <jsp:include page="paging_footer.jsp"></jsp:include>
    </ul>
  </div>
</div>
          <hr />
        </form>
      </div>

    </div>
    <!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="js/app.js"></script>
  </body>
</html>