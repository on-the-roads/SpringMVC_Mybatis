package com.ssm.Exception;
/**
 * 自定义异常
 * 系统遇到异常时，手动抛出，由dao自下而上抛给前端控制器DispatchServlet,前端控制器再调用全局异常处理器
 * @author Chenjiawen
 *
 */
public class ItemsCustomException extends Exception {
	String message;
	public ItemsCustomException(String message)
	{
		super(message);
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
