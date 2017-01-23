package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class QueryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String time1=request.getParameter("time1");
		String timeYear1=time1.substring(0,4);
		String timeMonth1=time1.substring(4,6);
		String timeDay1=time1.substring(6);
		time1=timeYear1+"-"+timeMonth1+"-"+timeDay1+" 00:00:00";
		System.out.println(time1);
		String time2=request.getParameter("time2");
		String timeYear2=time2.substring(0,4);
		String timeMonth2=time2.substring(4,6);
		String timeDay2=time2.substring(6);
		time2=timeYear2+"-"+timeMonth2+"-"+timeDay2+" 23:59:59";
		System.out.println(time2);
		String sql=new StringBuffer(" SELECT u.cp_name cpName,COUNT(*) orderNum,sum(o.price)/100 price ")
		.append(" FROM output_list o,cp_user u ")
		.append(" WHERE order_time BETWEEN ? AND ? ")
		.append(" AND u.cp_id=o.cp_id and o.orderstring_type<>3 GROUP BY o.cp_id ")
		.toString();
		List<Map<String,Object>> queryResultList=jdbcTemplate.queryForList(sql,time1,time2);
		request.setAttribute("queryResultList", queryResultList);
		request.getRequestDispatcher("page/query_manager.jsp").forward(request, response);
	}
	
}
