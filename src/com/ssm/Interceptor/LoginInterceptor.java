package com.ssm.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//判断url是否公开
		String url=request.getRequestURL().toString();
		if(url.indexOf("login.action")>0)//登录页面是公共页面，放行
			return true;
		//判断session
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null)
			return true;//用户存在，放行
		response.sendRedirect(request.getContextPath()+"/login.jsp");
//		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
