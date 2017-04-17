package cn.com.zlqf.spittr.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import cn.com.zlqf.spittr.exception.SpitterNotFoundException;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	public AppWideExceptionHandler() {
		System.out.println("创建AppWideExceptionHandler");
	}
	/*
	@ExceptionHandler(SpitterNotFoundException.class)
	public String handleSpitterNotFoundException() {
		System.out.println("SpitterNotFoundException");
		return "error/errorTemplate";
	}
	@ExceptionHandler(AuthorizationException.class) 
	public String handlerAuthorizationException(NativeWebRequest request){
		System.out.println(request);
		return "unauthorized";
	}
	*/
	
	@ExceptionHandler(Exception.class)
	public String handleOtherException(HttpServletRequest request,Exception e) {
		String errorMsg = null;
		System.out.println(e.getClass());
		if(e.getClass().equals(UnauthorizedException.class)) {
			errorMsg = "没有该权限";
		}else if(e.getClass().equals(SpitterNotFoundException.class)) {
			errorMsg = "没有该用户";
		}else {
			errorMsg = "未知错误";
		}
		request.setAttribute("errorMsg", errorMsg);
		return "error/errorTemplate";
	}
}
