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

public class SpQueryTelephoneServlet extends HttpServlet {

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
		String telephone=request.getParameter("telephone");
		System.out.println(telephone);
		String sql=new StringBuffer(" SELECT user_id,orderstring_type,order_time,price/100 price,product_name ")
		.append(" FROM output_list ")
		.append(" WHERE user_id=? and cp_id=?")
		.toString();
		List<Map<String,Object>> queryByTelephoneResultList=jdbcTemplate.queryForList(sql,telephone,cpId);
		if(queryByTelephoneResultList!=null&&queryByTelephoneResultList.size()>0){
			request.setAttribute("queryByTelephoneResultList", queryByTelephoneResultList);
			request.getRequestDispatcher("page/query_sp.jsp").forward(request, response);
		}else{
			System.out.println("查询无结果");
		}
		
	}

	
}
