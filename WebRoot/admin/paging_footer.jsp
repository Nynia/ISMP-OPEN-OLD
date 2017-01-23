<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int nowPage = Integer.parseInt(request.getAttribute("pageNumber")
			.toString());
%>
<script type="text/javascript">

function gotoSelectedPage(ao,page)
{
	
	$(ao).css("background","#ccc");
	//alert(page);
	var x = document.getElementById("navigatorForm");
	x.action = "<%=request.getAttribute("servlet")%>?pageNumber="+page;
	x.submit();
	//alert("Original action: " + x.action)
	return;
	var pageNumber = 1;
	if(page=="first"){
		x.action = "<%=request.getAttribute("servlet")%>?pageNumber="+pageNumber;
	}
	if(page=="prev"){
		x.action = "<%=request.getAttribute("servlet")%>?pageNumber=<%=new Integer(request.getAttribute("pageNumber")
							.toString()) - 1%>";
	}
	if(page=="next"){
		x.action = "<%=request.getAttribute("servlet")%>?pageNumber=<%=new Integer(request.getAttribute("pageNumber")
							.toString()) + 1%>";
	}
	if(page=="last"){

		x.action = "<%=request.getAttribute("servlet")%>?pageNumber=<%=new Integer(request.getAttribute("totalPages")
							.toString())%>";
	}
	x.submit();
}
</script>

<%
	if (new Integer(request.getAttribute("pageNumber").toString()) > 1) {
%>
<li>
	<a href="javascript:gotoSelectedPage(this,<%=nowPage - 1%>)">«</a>
</li>
<%
	} else {
%>
<li class="am-disabled">
	<a href="#">«</a>
</li>
<%
	}
%>
<%
	for (int j = 1; j <= new Integer(request.getAttribute("totalPages")
			.toString()); j++) {
%>
<li class="am-active">
	<a style="cursor: pointer;" name="pageNum" id="pageNum<%=j%>" href="#"
		onclick="gotoSelectedPage(this,<%=j%>);"><%=j%></a>
</li>
<%
	}
%>
<%
	if (new Integer(request.getAttribute("pageNumber").toString())
			.intValue() < new Integer(request
			.getAttribute("totalPages").toString()).intValue()) {
%>
<li>
	<a href="javascript:gotoSelectedPage(this,<%=nowPage + 1%>)">»</a>
</li>
<%
	} else {
%>
<li class="am-disabled">
	<a href="#">»</a>
</li>
<%
	}
%>

&nbsp; 共<%=request.getAttribute("totalPages")%>页&nbsp;|&nbsp;共<%=request.getAttribute("totalNum")%>条记录
