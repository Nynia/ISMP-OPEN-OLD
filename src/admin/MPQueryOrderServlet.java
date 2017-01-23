package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.PageQueryUtil;

public class MPQueryOrderServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		String type=null;
		if(request.getParameter("type")!=null){
			type=request.getParameter("type");
			
			//1.订购时间,2,手机号码
			if("1".equals(type)){
				String start=request.getParameter("start");
				String end=request.getParameter("end");
				System.out.println(start+"---"+end);
				String sql="select * from user_order where createtime between '"+start+"' and '"+end+"'";
				Object[] param = PageQueryUtil.getParam(request, sql, 15,
						jdbcTemplate);
				List res = jdbcTemplate.queryForList(sql + " limit ?,?", param);

				request.setAttribute("list", res);
				request.setAttribute("servlet", "queryorder");
				request.getRequestDispatcher("orderlist.jsp").forward(request, response);
			}
			if("2".equals(type)){
				String userid=request.getParameter("userid");
			//	System.out.println("linkid="+userid);
				
				String sql="select * from user_order where user_id="+userid;
				
				Object[] param = PageQueryUtil.getParam(request, sql, 15,
						jdbcTemplate);
				List res = jdbcTemplate.queryForList(sql + " limit ?,?", param);

				request.setAttribute("list", res);
				request.setAttribute("servlet", "queryorder");
				
				request.getRequestDispatcher("orderlist.jsp").forward(request, response);
			}
			if("3".equals(type)){
				String userid=request.getParameter("userid");
			//	System.out.println("linkid="+userid);
				String start=request.getParameter("start");
				String end=request.getParameter("end");
				String sql="select * from user_order where user_id="+userid+" and createtime between '"+start+"' and '"+end+"'";
				
				Object[] param = PageQueryUtil.getParam(request, sql, 15,
						jdbcTemplate);
				List res = jdbcTemplate.queryForList(sql + " limit ?,?", param);

				request.setAttribute("list", res);
				request.setAttribute("servlet", "queryorder");
				
				request.getRequestDispatcher("orderlist.jsp").forward(request, response);
			}
		}else{
			
			String sql="select * from user_order";
			
			Object[] param = PageQueryUtil.getParam(request, sql, 15,
					jdbcTemplate);
			List res = jdbcTemplate.queryForList(sql + " limit ?,?", param);

			request.setAttribute("list", res);
			request.setAttribute("servlet", "queryorder");
			
			request.getRequestDispatcher("orderlist.jsp").forward(request, response);
			
		}
		
		
		
	}

}
