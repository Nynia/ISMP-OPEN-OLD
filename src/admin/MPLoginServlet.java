package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.DBUtil;

public class MPLoginServlet extends HttpServlet {

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
		
		String username = request.getParameter("username");
		
		String pwd = request.getParameter("pwd");
		
		List res = null;
		
		if (username == null || username.length() == 0) {
			return;
		}
		if (pwd == null || pwd.length() == 0) {
			return;
		}
		res = jdbcTemplate
				.queryForList(
						"select * from cp_user where cp_account=? and cp_pwd = ? ",
						new Object[] { username, util.EncodeByMd5.encode(pwd) });
			System.out.println("res=="+res);
		
	
			
			if (res == null || res.size() == 0) {
				//out.print("0");
				out
						.print("<script type=\"text/javascript\">alert(\"用户名或密码有误，请重新输入\");window.location.href=\"login.jsp\"</script>");
				out
						.print("<script type=\"text/javascript\">window.history.back(-1);</script>");
				return;

			}
			
//			Iterator it = res.iterator();
//			if (it.hasNext()) {
//				Map map = (Map) it.next();
//				
//				List user_list = jdbcTemplate.queryForList("SELECT * FROM admin_jiayi WHERE admin_name != ?",new Object[]{
//						map.get("admin_name").toString()
//				});
//			
//				
//			List user_list_all = jdbcTemplate.queryForList("select * from admin_jiayi ");
//			List brand_list = jdbcTemplate.queryForList("select * from brand_jiayi");
//			request.getSession().setAttribute("admin_id", map.get("id"));
			
			List userList=(List)jdbcTemplate.queryForList("select * from cp_operator where cp_account=?",new Object[]{username});
			Map userMap=(Map)userList.get(0);
			String cpid=userMap.get("cp_id").toString();
			String role=userMap.get("role_id").toString();
			request.getSession().setAttribute("role",role);
			request.getSession().setAttribute("username",username);
			request.getSession().setAttribute("cpid",cpid);
//			//request.getSession().setAttribute("brand_list", brand_list);
//			request.getSession().setAttribute("user_list", user_list);
//			request.getSession().setAttribute("user_list_all", user_list_all);
//			}
			
			
			
			request.getRequestDispatcher("main.jsp").forward(request,
					response);
	
	}

}
