package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;


public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session=((HttpServletRequest)request).getSession();
		User user=(User) session.getAttribute("user");
		// 登录页面访问的时候
		String url = ((HttpServletRequest)request).getRequestURI();
		if(url.endsWith("login.jsp")||url.endsWith("loginServlet")||url.endsWith("register.jsp")||url.endsWith("registerServlet")){
			chain.doFilter(request, response);
			return;
		}
		if(user!=null){
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
