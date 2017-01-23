package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MPUpdateProInfoServlet extends HttpServlet {

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
		
		String id=request.getParameter("id");
		String accessnum=request.getParameter("accessnum");
		String proname=request.getParameter("proname");
		String ismppid=request.getParameter("ismppid");
		String bussinessid=request.getParameter("bussinessid");
		String orderstring=request.getParameter("orderstring");
		String tdorderstring=request.getParameter("tdorderstring");
		String dgorderstring=request.getParameter("dgorderstring");
		String typesel=request.getParameter("typesel");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		if("1".equals(typesel)){
			jdbcTemplate.update("update product_info set access_num=?,ismp_product_id=?,ismp_bussiness_id=?,product_name=?,order_string=?,td_orderstring=?,orderstring_type=?,price=?,description=? where product_id=?",
					new Object[]{
					accessnum,ismppid,bussinessid,proname,orderstring,tdorderstring,typesel,price,description,id
			});
		}
		if("2".equals(typesel)){
			jdbcTemplate.update("update product_info set access_num=?,ismp_product_id=?,ismp_bussiness_id=?,product_name=?,order_string=?,td_orderstring=?,orderstring_type=?,price=?,description=? where product_id=?",
					new Object[]{
					accessnum,ismppid,bussinessid,proname,dgorderstring,tdorderstring,typesel,price,description,id
			});
		}
		
		
		out.print("updateOK");
		
		
	}

}
