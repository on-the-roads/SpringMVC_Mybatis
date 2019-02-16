package com.ssm.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器，实现HandlerExceptionResolver接口
 * @author Chenjiawen
 *
 */
public class ItemsCustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		
		ItemsCustomException CustomException=null;
		//解析异常
		//该异常是自定义异常，直接取出异常信息，在错误页面显示
		//不是自定义的异常，则构造一个自定义的异常类型，在错误页面显示
		if (ex instanceof ItemsCustomException) {
			CustomException = (ItemsCustomException) ex;
		}else {
			CustomException=new ItemsCustomException("unknown error");
		}
		
		String messageString=CustomException.getMessage();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("errmessage", messageString);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
