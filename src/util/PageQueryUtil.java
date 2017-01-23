package util;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
/*
 * @分页核心类
 * @author: 王欢
 * @createtime: 12-11-2010
 */
public class PageQueryUtil {

	/*
	 * @该方法会返回给用户总页数, 总记录数, 当前页数,
	 */
	public static Object[] getParam(HttpServletRequest request, String sql,
			int pageSize, JdbcTemplate jdbcTemplate) 
	{
		String pageNumberStr = request.getParameter("pageNumber");
		int pageNumber = 1;
		if (pageNumberStr != null) 
		{
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		
		
		System.out.println("总共--"+"select count(*) from (" + sql
				+ ") a");
		int totalNum = jdbcTemplate.queryForInt("select count(*) from (" + sql
				+ ") a");
		System.out.println("totalNum---"+totalNum);
		System.out.println("跳到---"+pageNumber);
		int totalPages = totalNum / pageSize
				+ ((totalNum % pageSize) > 0 ? 1 : 0);
		System.out.println("totalPages--"+totalPages);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalNum", totalNum);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("totalPages", totalPages);
		return new Object[] { pageSize * (pageNumber - 1), pageSize };
	}
	
	public static Map getParamAjax(HttpServletRequest request, String sql,
			int pageSize, JdbcTemplate jdbcTemplate) 
	{
		String pageNumberStr = request.getParameter("pageNumber");
		int pageNumber = 1;
		if (pageNumberStr != null) 
		{
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		System.out.println("总共--"+"select count(*) from (" + sql
				+ ") a");
		int totalNum = jdbcTemplate.queryForInt("select count(*) from (" + sql
				+ ") a");
		System.out.println("totalNum---"+totalNum);
		int totalPages = totalNum / pageSize
				+ ((totalNum % pageSize) > 0 ? 1 : 0);
		System.out.println("totalPages--"+totalPages);
		System.out.println("跳到---"+pageNumber);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("pageSize", pageSize);
		m.put("totalNum", totalNum);
		m.put("pageNumber", pageNumber);
		m.put("totalPages", totalPages);
		m.put("param", new Object[] { pageSize * (pageNumber - 1), pageSize });
		return m;
	}
}
