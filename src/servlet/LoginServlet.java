package servlet;

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

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=util.EncodeByMd5.encode(request.getParameter("pwd"));
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql="select * from cp_user where cp_account=? and cp_pwd=?";
		List<Map<String,Object>> res=jdbcTemplate.queryForList(sql, new Object[]{name,pwd});
		if(res!=null&&res.size()>0){
			String cp_id=res.get(0).get("cp_id")+"";
			System.out.println("cp_id="+cp_id);
			request.getSession().setAttribute("cp_id", cp_id);
			System.out.println("登陆成功");
			out.print("success");
			return;
		}
		System.out.println("账号密码错误");
		out.print("false");
	}

}
