package cn.jxy.sdnweb.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.jxy.sdnweb.entity.User;
import cn.jxy.sdnweb.util.Routes;





/**
 * Servlet Filter implementation class ExcelFilter
 */

public class ExcelFilter implements Filter {
	
	private FilterConfig Config;
	
	/**
	 * Default constructor.
	 */
	public ExcelFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); // 转码
		HttpServletRequest hRequest = (HttpServletRequest) request;
		
		List<Routes> routess = (List<Routes>) hRequest.getSession().getAttribute("routess");// 获得登陆用户
		String returnUrl = hRequest.getContextPath() + "/weight/toIndex";
		
		if(routess==null){
			response.getWriter()
			.println("<script language=\"javascript\">" +"alert(\"路由表为空！无法导出\");"+ "if(window.opener==null){window.top.location.href=\""
					+ returnUrl + "\";}else{window.opener.top.location.href=\"" + returnUrl
					+ "\";window.close();}</script>");
			return;
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		Config = fConfig;
	}

}
