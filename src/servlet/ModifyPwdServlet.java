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

public class ModifyPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String pwd=request.getParameter("newPwd1");
		pwd=util.MD5.compile(pwd);
		System.out.println(pwd);
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		String sql="select * from cp_user where cp_account=?";
		List<Map<String,Object>> userList=jdbcTemplate.queryForList(sql,account);
		if(userList==null||userList.size()==0){
			return;
		}
		sql="update cp_user set cp_pwd=? where cp_account=?";
		int result=jdbcTemplate.update(sql,new Object[]{pwd,account});
		String modifyPwdResult="";
		if(result>0){
			modifyPwdResult="修改成功";
		}else{
			modifyPwdResult="修改失败";
		}
		request.setAttribute("modifyPwdResult", modifyPwdResult);
		request.getRequestDispatcher("page/modifyPwdResult.jsp").forward(request, response);
	}
}
