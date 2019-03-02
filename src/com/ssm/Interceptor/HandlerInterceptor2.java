package com.ssm.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor{

	//进入Handler方法之前执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		//return false; 拦截，不继续向下执行
		//return true;放行
		System.out.println("HandlerInterceptor2 preHandle...");
		return true;
	}
	
	//进入Handler方法之后返回ModelandView之前执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2 postHandle...");
		
	}
	
	//Handler方法完成后执行此方法
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor2 afterCompletion...");

	}




}
