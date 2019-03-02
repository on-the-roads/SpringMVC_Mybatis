package com.ssm.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	// @Autowired
	// private UserService userservice;

	@RequestMapping("/login.action")
	public String login(HttpSession session, String username, String password)
			throws Exception {

		if (username.equals("ontheroad") && password.equals("123"))
			session.setAttribute("username", username);// session中保存用户信息
		else {
			session.setAttribute("errmsg", "您的管理员用户名或者密码错误！");
		}
		return "redirect:/items/queryItems.action";
	}

	@RequestMapping("/logout.action")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/items/queryItems.action";

	}
}
