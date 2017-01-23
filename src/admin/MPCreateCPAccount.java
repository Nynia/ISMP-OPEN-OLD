package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.DBUtil;


public class MPCreateCPAccount extends HttpServlet {

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
		
		String cpname=request.getParameter("cpname");
		String cpaccount=request.getParameter("cpaccount");
		
		String cppwd=request.getParameter("cppwd");
		cppwd=util.EncodeByMd5.encode(cppwd);
		
		String accessnum=request.getParameter("accessnum");
		
//		jdbcTemplate.update("insert into cp_user values(?,?,?,?,?,?,?,?,?,?)",new Object[]{
//				cpname,accessnum,cpaccount,cppwd,"","","",null,new Date(),0
//		});
		
		String sql="insert into cp_user values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			int cpID=DBUtil.getPrimaryKeyAfterInsertToDB(jdbcTemplate, sql, null,cpname,accessnum,cpaccount,cppwd,"","","",null,new Date(),0);
		
			jdbcTemplate.update("insert into cp_operator values(?,?,?)",new Object[]{
					cpID,cpaccount,2
			});
			
			out.print("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
