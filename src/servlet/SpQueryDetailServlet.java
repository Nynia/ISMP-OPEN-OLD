package servlet;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpQueryDetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String cpId=request.getParameter("cp_id");
		System.out.println(cpId);
		String year=request.getParameter("year");
		System.out.println(year);
		String month=request.getParameter("month");
		System.out.println(month);
		String day1="01";
		String day2="30";
		if("01".equals(month)||"03".equals(month)||"05".equals(month)||"07".equals(month)||"08".equals(month)||"10".equals(month)||"12".equals(month)){
			day2="31";
		}
		String sqlDate1=year+"-"+month+"-"+day1+" 00:00:00";
		System.out.println(sqlDate1);
		String sqlDate2=year+"-"+month+"-"+day2+" 23:59:59";
		System.out.println(sqlDate2);
		String sql=new StringBuffer(" SELECT user_id,orderstring_type,order_time,price/100 price,product_name ")
		.append(" FROM output_list ")
		.append(" WHERE cp_id=?")
		.append(" and order_time between ? and ?")
		.toString();
		List<Map<String,Object>> queryDetailByDateList=jdbcTemplate.queryForList(sql,cpId,sqlDate1,sqlDate2);
		if(queryDetailByDateList!=null&&queryDetailByDateList.size()>0){
			request.setAttribute("queryDetailByDateList", queryDetailByDateList);
			request.getRequestDispatcher("page/query_sp.jsp").forward(request, response);
		}else{
			System.out.println("查询无结果");
		}
		
	}

	
}
