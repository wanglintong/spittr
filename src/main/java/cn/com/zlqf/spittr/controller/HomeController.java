package cn.com.zlqf.spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeController()...");
	}
	
	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}
}
