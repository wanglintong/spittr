package cn.com.zlqf.spittr.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request,String username,String password,Model model) {
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {//如果用户未认证
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			token.setRememberMe(true);
			try {
				subject.login(token);
			} catch(IncorrectCredentialsException e){
				model.addAttribute("loginMsg", "用户名或密码错误");
				return "login";
			} catch(UnknownAccountException e) {
				model.addAttribute("loginMsg", "账号不存在");
				return "login";
			} catch(AuthenticationException e) {
				model.addAttribute("loginMsg", "登录失败");
				return "login";
			}
		}
		request.getSession().setAttribute("username", username);
		String requestURI = WebUtils.getSavedRequest(request).getRequestURI();
		requestURI = requestURI.replace("/spittr", "");
		return "redirect:" + requestURI;
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		
		return "unauthorized";
	}
}
