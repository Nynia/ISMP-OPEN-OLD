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
List list=(List)request.getAttribute("list");

System.out.println("----"+list);

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
  <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
  <script>
	
	function cpdetail(id,name){
		window.self.location.href="cpdetail.jsp?id="+id+"&name="+name;
	}
	
	function cppro(id,name){
		window.self.location.href="cppro.jsp?id="+id+"&name="+name;
	}
	
	function tj(){
	//1.CP，2.linkid 3.订购时间,4.手机号，5.手机号+时间
		var userid=$("#phone").val();
		var linkid=$("#linkid").val();
		var start=$("#datetimepicker2").val();
		var end =$("#datetimepicker3").val();
		if($.trim(userid)!=""&&$.trim(userid).length!=11){
			alert("请输入11位手机号码");
			return;
		}
		if($.trim(userid)!=""&&start!=""&&end==""){
			alert("请输入截止日期");
			return;
		}
		if($.trim(userid)!=""&&start==""&&end!=""){
			alert("请输入开始日期");
			return;
		}
		if($.trim(userid)==""&&start!=""&&end==""){
			alert("请输入截止日期");
			return;
		}
		if($.trim(userid)==""&&start==""&&end!=""){
			alert("请输入开始日期");
			return;
		}
		//alert(userid+"--"+start+"--"+end);
		//1.CP，2.linkid 3.订购时间,4.手机号，5.手机号+时间
		if($.trim(userid)==""&&start==""&&end==""&&$.trim(linkid)==""){
			window.self.location.href="querycpoutput?type=1";
		}
		if($.trim(linkid)!=""){
			window.self.location.href="querycpoutput?type=2&linkid="+linkid;
		}
		if($.trim(userid)!=""&&start==""&&end==""){
			window.self.location.href="querycpoutput?type=4&userid="+userid;
		}
		
		if($.trim(userid)==""&&start!=""&&end!=""){
			window.self.location.href="querycpoutput?type=3&start="+start+"&end="+end;
		}
		if($.trim(userid)!=""&&start!=""&&end!=""){
			window.self.location.href="querycpoutput?type=5&userid="+userid+"&start="+start+"&end="+end;
		}
		
	}
	
</script>
</head>
<body style="min-height:750px;">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">详单列表</strong> / <small>Output List</small></div>
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
          
          <div class="am-btn-group am-btn-group-xs">
            <span style="text-align:left;" class="am-btn am-btn-default">LinkID：<input type="text"  id="linkid" name="linkid" maxlength="30"/></span>
            <span style="text-align:left;" class="am-btn am-btn-default">用户号码：<input type="text"  id="phone" name="phone" maxlength="11"/></span>
            <span style="text-align:left;"  class="am-btn am-btn-default">起始日期：<span class=""><input type="text"  id="datetimepicker2" maxlength="11"/></span></span>
            <span style="text-align:left;"  class="am-btn am-btn-default">截止日期：<span class=""><input type="text"  id="datetimepicker3" maxlength="11"/></span></span>
            
            
            </div>
        <a style="" type="button" onclick="tj()" class="am-btn am-btn-primary am-btn-xs">查询详单</a>
          
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-title">用户号码</th><th class="table-title">归属地</th><th class="table-type">LinkID</th><th class="table-type">接入号</th><th class="table-type">流水号</th><th class="table-date">订购行为</th><th class="table-set">资费</th><th class="table-set">订购时间</th>
              </tr>
          </thead>
          <tbody>
          <%
									int i = 0;  
							Iterator it = list.iterator();  
							while(it.hasNext()){  
								i++;
							Map	m=(Map)it.next();  
							%>
            <tr>
              <td><%=i %></td>
              <td><a href="#"><%=m.get("user_id") %></a></td>
              <td><%=m.get("location")%></td>
              <td><%=m.get("link_id")%></td>
              <td><%=m.get("access_num")%></td>
              <td><%=m.get("stream_no")%></td>
              <td><%if("1".equals(m.get("orderstring_type").toString())){out.print("点播");}
              if("2".equals(m.get("orderstring_type").toString())){out.print("包月");}
              if("3".equals(m.get("orderstring_type").toString())){out.print("退订");}
               %></td>
              <td>￥<%=AmountUtils.changeF2Y(m.get("price").toString()) %>&nbsp;元</td>
              <td><%=m.get("order_time").toString().substring(0,m.get("order_time").toString().length()-2) %></td>
              
            </tr>
            <%} %>
          </tbody>
        </table>
          <div class="am-cf">
  共 <%=list.size() %> 条记录
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
<!--  -->