package cn.com.zlqf.spittr.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.com.zlqf.spittr.exception.SpitterNotFoundException;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	public AppWideExceptionHandler() {
		System.out.println("创建AppWideExceptionHandler");
	}

	@ExceptionHandler(SpitterNotFoundException.class)
	public String handleSpitterNotFoundException() {
		System.out.println("SpitterNotFoundException");
		return "error/errorTemplate";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleOtherException() {
		System.out.println("OtherException");
		return "error/errorTemplate";
	}
}
