package cn.com.zlqf.spittr.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSubmit(String username,String password) {
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {//如果用户未认证
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			token.setRememberMe(true);
			try {
				subject.login(token);
			} catch(AuthenticationException e) {
				System.out.println("登录失败");
			}
		}
		return "home";
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		
		return "unauthorized";
	}
}
