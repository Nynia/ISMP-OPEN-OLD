<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%
ApplicationContext ctx = WebApplicationContextUtils
.getWebApplicationContext(this.getServletContext());
JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
System.out.println(request.getSession().getAttribute("cpid"));
List cpname=(List)jdbcTemplate.queryForList("select * from cp_user where cp_id=?",new Object[]{request.getSession().getAttribute("cpid")});
Map nameMap=(Map)cpname.get(0);
String name=nameMap.get("cp_name").toString();
 %>
<!-- sidebar start -->
  <script>
  	function jump(v){
  			window.frames['selectmain'].location.href=v;
  			if(v=='cpdetail'){
  				window.frames['selectmain'].location.href="cpdetail2.jsp?id=<%=request.getSession().getAttribute("cpid")%>&name=<%=name%>";
  			}
  	}
  </script>
    <ul class="am-list admin-sidebar-list">
      <li><a href="main.jsp"><span class="am-icon-home"></span> 平台首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 基本信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="javascript:void(0)" onclick="jump('cpdetail')" class="am-cf"><span class="am-icon-check"></span> 基本信息<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="javascript:void(0)" onclick="jump('prolist?id=<%=request.getSession().getAttribute("cpid")%>')" class="am-cf"><span class="am-icon-check"></span> 产品列表<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="javascript:void(0)" onclick="jump('newpro.jsp')" class="am-cf"><span class="am-icon-check"></span> 新增产品<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li>
      
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-file"></span>  详单查询 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="javascript:void(0)" onclick="jump('querycpoutput?type=1&cpid=<%=request.getSession().getAttribute("cpid").toString() %>')" class="am-cf"><span class="am-icon-check"></span> 所有详单</a></li>
        </ul>
      </li> 
      
      
      
      
      <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> 欢迎</p>
        <p>欢迎来到汇聚平台！</p>
      </div>
    </div>
  <!-- sidebar end -->
