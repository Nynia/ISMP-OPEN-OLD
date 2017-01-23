package util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTools {
	public static void SetHeaderForServlet(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		response.setHeader("Pragma", "No-Cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-Cache");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
}
