package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MPCPNewProServlet extends HttpServlet {

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
		
		String cpid=request.getSession().getAttribute("cpid").toString();
		
		String proname=request.getParameter("proname");
		String accessnum=request.getParameter("accessnum");
		String ismpid=request.getParameter("ismpid");
		String bussinessid=request.getParameter("bussinessid");
		String orderstring=request.getParameter("orderstring");
		String tdorderstring=request.getParameter("tdorderstring");
		String typesel=request.getParameter("typesel");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		jdbcTemplate.update("insert into product_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]{
				null,cpid,ismpid,bussinessid,accessnum,proname,orderstring,tdorderstring,typesel,price,description,0,new Date()
		});
		
		out.print("OK");
	}

}
