<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- sidebar start -->
  <script>
  	function jump(v){
  			window.frames['selectmain'].location.href=v;
  	}
  </script>
    <ul class="am-list admin-sidebar-list">
      <li><a href="main.jsp"><span class="am-icon-home"></span> 平台首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> CP信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a style="cursor:pointer;" onclick="jump('cplist')" class="am-cf"><span class="am-icon-check"></span> 接入CP列表<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          <li><a href="javascript:void(0)" onclick="jump('newcp.jsp')" class="am-cf"><span class="am-icon-check"></span> 分配cp帐号<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li>
      
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-file"></span> 产品管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
          <li><a href="javascript:void(0)" onclick="jump('prolist')" class="am-cf"><span class="am-icon-check"></span> 现有产品管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li>
      
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-file"></span>  话单查询 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="javascript:void(0)" onclick="jump('queryorder')" class="am-cf"><span class="am-icon-check"></span> 所有话单</a></li>
        </ul>
      </li> 
      
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-file"></span>  详单查询 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav4">
          <li><a href="javascript:void(0)" onclick="jump('queryoutput')" class="am-cf"><span class="am-icon-check"></span> 所有详单</a></li>
        </ul>
      </li> 
      
      <!--<li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-file"></span> APP社区管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="javascript:void(0)" onclick="jump('appindex?type=8')" class="am-cf"><span class="am-icon-check"></span> 社区顶部轮播图管理</a></li>
        </ul>
      </li> 
      
       <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-file"></span> 广告位管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav3">
          <li><a href="javascript:void(0)" onclick="jump('appindex?type=9')" class="am-cf"><span class="am-icon-check"></span> 频道广告位</a></li>
          <li><a href="javascript:void(0)" onclick="jump('appindex?type=10')"><span class="am-icon-puzzle-piece"></span> 社区广告位</a></li>
        </ul>
      </li> 
      
      <li><a href="admin-table.html"><span class="am-icon-table"></span> 表格</a></li>
      <li><a href="admin-form.html"><span class="am-icon-pencil-square-o"></span> 表单</a></li>-->
      <li><a href="login.jsp"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <!--  <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>时光静好，与君语；细水流年，与君同。—— Amaze</p>
      </div>
    </div>-->

   <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> 欢迎</p>
        <p>欢迎来到汇聚平台！</p>
      </div>
    </div>
  <!-- sidebar end -->
