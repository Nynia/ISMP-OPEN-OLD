<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query_manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="page/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function queryTotalByDate(){
			var reg=/^(\d{4})(\d{2})(\d{2})$/;
			if($("#time1").val()==""||$("#time1").val()==""){
				$("#checkResult").html("please enter right date");
				$("#checkResult").css("color","red");
				return false;
			}
			else{
				$("#checkResult").html("ok");
				$("#checkResult").css("color","green");
			}
			if(reg.test($("#time1").val())){
					$("#queryForm").submit();
			}else{
				return;
			}
			
		}

		function queryByTelephone(){
			var reg=/^[0-9]{11}$/;
			if($("#telephone").val()==""){
				$("#checkTelephoneResultDiv").html("please enter right phone");
				$("#checkTelephoneResultDiv").css("color","red");
				return false;
			}
			else{
				$("#checkTelephoneResultDiv").html("ok");
				$("#checkTelephoneResultDiv").css("color","green");
			}
			if(reg.test($("#telephone").val())){
					$("#queryTelephoneForm").submit();
			}else{
				return;
			}
			
		}
	</script>
  </head>
  
  <body>
  	请输入查询时间段: 例如 "20151101"
  	<form id="queryForm" action="${pageContext.request.contextPath}/queryServlet" method="post">
  		<input id="time1" name="time1"/>-<input id="time2" name="time2"/>
    	<input type="submit" value="query" onclick="return queryTotalByDate()"/>
	</form>
	<div id="checkResult"></div>
	
    <div>
    	<table border="1">
    		<tr>
    			<td>Cp名称</td>
    			<td>订购量</td>
    			<td>费用总计</td>
    		</tr>
    		<%
    			if(request.getAttribute("queryResultList")!=null){
    			List<Map<String,Object>> queryResultList=(List<Map<String,Object>>)request.getAttribute("queryResultList");
    			for(int i=0;i<queryResultList.size();i++){
    				String cpName=queryResultList.get(i).get("cpName")+"";
    				String orderNum=queryResultList.get(i).get("orderNum")+"";
    				String price=queryResultList.get(i).get("price")+"";
    				out.println("<tr><td>"+cpName+"</td><td>"+orderNum+"</td><td>"+price+"</td></tr>");
    			}
    			}
    		%>
    	</table>
    </div>
    <br/> <br/> <br/> <br/> <br/>
    <div>
    	请输入手机号码：例如”18115886196“
	  	<form id="queryTelephoneForm" action="${pageContext.request.contextPath}/managerQueryTelephoneServlet" method="post">
	  		<input id="telephone" name="telephone"/>
	    	<input type="submit" value="query" onclick="return queryByTelephone()"/>
		</form>
		<div id="checkTelephoneResultDiv"></div>
    </div>
    <div>
    	<table border="1">
    		<tr>
    			<td>手机号码</td>
    			<td>订购类型</td>
    			<td>订购时间</td>
    			<td>资费</td>
    			<td>Cp名称</td>
    		</tr>
    		<%
    			if(request.getAttribute("queryByTelephoneResultList")!=null){
    			List<Map<String,Object>> queryByTelephoneResultList=(List<Map<String,Object>>)request.getAttribute("queryByTelephoneResultList");
    			for(int i=0;i<queryByTelephoneResultList.size();i++){
    				String phone=queryByTelephoneResultList.get(i).get("user_id")+"";
    				String orderType=queryByTelephoneResultList.get(i).get("orderstring_type")+"";
    				if("1".equals(orderType)){
    					orderType="点播";
    				}else if("2".equals(orderType)){
    					orderType="包月";
    				}else{
    					orderType="退订";
    				}
    				String orderTime=queryByTelephoneResultList.get(i).get("order_time")+"";
    				String price=queryByTelephoneResultList.get(i).get("price")+"";
    				String cpName=queryByTelephoneResultList.get(i).get("cp_name")+"";
    				out.println("<tr><td>"+phone+"</td><td>"+orderType+"</td><td>"+orderTime+"</td><td>"+price+"</td><td>"+cpName+"</td></tr>");
    			}
    			}
    		%>
    	</table>
    </div>
  </body>
</html>
